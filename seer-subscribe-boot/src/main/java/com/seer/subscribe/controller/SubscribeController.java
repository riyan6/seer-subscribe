package com.seer.subscribe.controller;

import com.seer.node.model.biz.Protocol;
import com.seer.node.sdk.ProtocolSdk;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subscribes")
@Slf4j
public class SubscribeController {

    @DubboReference
    private ProtocolSdk protocolSdk;

    @GetMapping("/my")
    public List<Protocol> getMyProtocols() {
        List<Protocol> protocols = protocolSdk.getMyProtocols();
        log.info("protocols length: {} data: {}", protocols.size(), protocols);
        return protocols;
    }

}
