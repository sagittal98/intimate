package com.intimate.common.authorization.impl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.Proxy.Type;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

public class WeChatHttpRequest {

    private String charset = "utf-8";
    private Integer connectTimeout = null;
    private Integer socketTimeout = null;
    private String proxyHost = null;
    private Integer proxyPort = null;

    String doGet(String url) throws Exception {
        URL localURL = new URL(url);
        URLConnection connection = this.openConnection(localURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        httpURLConnection.setRequestProperty("Accept-Charset", this.charset);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuilder resultBuffer = new StringBuilder();
        String tempLine = null;
        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        } else {
            try {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                reader = new BufferedReader(inputStreamReader);

                while((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }

                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }

                if (inputStream != null) {
                    inputStream.close();
                }

            }
            return resultBuffer.toString();
        }
    }

    /**
     *
     * @param url 请求地址
     * @param parameterMap
     * @return
     * @throws Exception
     */
    public String doPost(String url, Map parameterMap) throws Exception {
        StringBuilder parameterBuffer = new StringBuilder();
        if (parameterMap != null) {
            Iterator iterator = parameterMap.keySet().iterator();
            String key = null;
            String value = null;

            while(iterator.hasNext()) {
                key = (String)iterator.next();
                if (parameterMap.get(key) != null) {
                    value = (String)parameterMap.get(key);
                } else {
                    value = "";
                }

                parameterBuffer.append(key).append("=").append(value);
                if (iterator.hasNext()) {
                    parameterBuffer.append("&");
                }
            }
        }

        System.out.println("POST parameter : " + parameterBuffer.toString());
        URL localURL = new URL(url);
        URLConnection connection = this.openConnection(localURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", this.charset);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuilder resultBuffer = new StringBuilder();
        String tempLine = null;

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(parameterBuffer.toString());
            outputStreamWriter.flush();
            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }

        return resultBuffer.toString();
    }

    /**
     * post请求，参数为json字符串
     * @param url 请求地址
     * @param jsonString json字符串
     * @return 响应
     */
    public String postJson(String url,String jsonString) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new ByteArrayEntity(jsonString.getBytes(StandardCharsets.UTF_8)));
            response = httpClient.execute(post);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     *
     * @param entity
     * @return
     * @throws IOException
     */
    private String entityToString(HttpEntity entity) throws IOException {
        String result = null;
        if(entity != null)
        {
            long lenth = entity.getContentLength();
            if(lenth != -1 && lenth < 2048)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }else {
                InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
                CharArrayBuffer buffer = new CharArrayBuffer(2048);
                char[] tmp = new char[1024];
                int l;
                while((l = reader1.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }
                result = buffer.toString();
            }
        }
        return result;
    }

    private URLConnection openConnection(URL localURL) throws IOException {
        URLConnection connection;
        if (this.proxyHost != null && this.proxyPort != null) {
            Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(this.proxyHost, this.proxyPort));
            connection = localURL.openConnection(proxy);
        } else {
            connection = localURL.openConnection();
        }

        return connection;
    }

    private void renderRequest(URLConnection connection) {
        if (this.connectTimeout != null) {
            connection.setConnectTimeout(this.connectTimeout);
        }

        if (this.socketTimeout != null) {
            connection.setReadTimeout(this.socketTimeout);
        }

    }

    public WeChatHttpRequest() {
    }

    public String getCharset() {
        return this.charset;
    }

    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    public Integer getSocketTimeout() {
        return this.socketTimeout;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public Integer getProxyPort() {
        return this.proxyPort;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof WeChatHttpRequest)) {
            return false;
        } else {
            WeChatHttpRequest other = (WeChatHttpRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$charset = this.getCharset();
                    Object other$charset = other.getCharset();
                    if (this$charset == null) {
                        if (other$charset == null) {
                            break label71;
                        }
                    } else if (this$charset.equals(other$charset)) {
                        break label71;
                    }

                    return false;
                }

                Object this$connectTimeout = this.getConnectTimeout();
                Object other$connectTimeout = other.getConnectTimeout();
                if (this$connectTimeout == null) {
                    if (other$connectTimeout != null) {
                        return false;
                    }
                } else if (!this$connectTimeout.equals(other$connectTimeout)) {
                    return false;
                }

                label57: {
                    Object this$socketTimeout = this.getSocketTimeout();
                    Object other$socketTimeout = other.getSocketTimeout();
                    if (this$socketTimeout == null) {
                        if (other$socketTimeout == null) {
                            break label57;
                        }
                    } else if (this$socketTimeout.equals(other$socketTimeout)) {
                        break label57;
                    }

                    return false;
                }

                Object this$proxyHost = this.getProxyHost();
                Object other$proxyHost = other.getProxyHost();
                if (this$proxyHost == null) {
                    if (other$proxyHost != null) {
                        return false;
                    }
                } else if (!this$proxyHost.equals(other$proxyHost)) {
                    return false;
                }

                Object this$proxyPort = this.getProxyPort();
                Object other$proxyPort = other.getProxyPort();
                if (this$proxyPort == null) {
                    if (other$proxyPort == null) {
                        return true;
                    }
                } else if (this$proxyPort.equals(other$proxyPort)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof WeChatHttpRequest;
    }



    public String toString() {
        return "HttpRequest(charset=" + this.getCharset() + ", connectTimeout=" + this.getConnectTimeout() + ", socketTimeout=" + this.getSocketTimeout() + ", proxyHost=" + this.getProxyHost() + ", proxyPort=" + this.getProxyPort() + ")";
    }
}
