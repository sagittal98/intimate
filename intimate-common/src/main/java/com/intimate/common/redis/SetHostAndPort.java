package com.intimate.common.redis;

import redis.clients.jedis.HostAndPort;

import java.util.Set;

public class SetHostAndPort {

    private Set<HostAndPort> hostAndPortSet;

    public Set<HostAndPort> getHostAndPortSet() {
        return hostAndPortSet;
    }

    public void setHostAndPortSet(Set<HostAndPort> hostAndPortSet) {
        this.hostAndPortSet = hostAndPortSet;
    }
}
