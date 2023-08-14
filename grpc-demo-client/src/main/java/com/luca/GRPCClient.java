package com.luca;

import com.luca.grpc.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.luca.grpc.userGrpc;

public class GRPCClient {

    public static void main(String[] args) {

        // create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",9090)
                .usePlaintext()
                .build();

        // stubs to connect to particular endpoints
        // generate from proto
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest = User.LoginRequest.newBuilder()
                .setUsername("Luca")
                .setPassword("Luca")
                .build();

        User.APIResponse response = userStub.login(loginRequest);
        System.out.println(response.getResponseMessage());
    }
}
