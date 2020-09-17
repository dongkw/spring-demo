package xyz.jecy.anox.controller;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import xyz.jecy.api.axon.bean.cmd.CapitalAddCmd;
import xyz.jecy.api.axon.bean.cmd.CapitalCreatCmd;
import xyz.jecy.api.axon.bean.cmd.CapitalSubtractCmd;
import xyz.jecy.api.axon.bean.cmd.TransferCmd;
import xyz.jecy.util.response.Response;

import java.util.UUID;


/**
 * @Author dongkw
 * @Date 2020/9/4、15:30
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("capital/create")
    public Response createCapital(@RequestBody CapitalCreatCmd cmd) {
        commandGateway.send(cmd);
        return Response.initSuccess();
    }

    @PostMapping("capital/add")
    public Response addCapital(@RequestBody CapitalAddCmd cmd) {
        commandGateway.send(cmd);
        return Response.initSuccess();
    }
    @PostMapping("capital/subtract")
    public Response subtractCapital(@RequestBody CapitalSubtractCmd cmd) {
        commandGateway.send(cmd);
        return Response.initSuccess();
    }
    @PostMapping("capital/transfer")
    public Response transfer(@RequestBody TransferCmd cmd) {
        UUID s = UUID.randomUUID();
        cmd.setTransferId(s.toString());
        commandGateway.send(cmd);
        return Response.initSuccess();
    }


}
