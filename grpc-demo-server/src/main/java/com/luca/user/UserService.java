package com.luca.user;

import com.luca.grpc.User;
import com.luca.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside login");

        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        // business logic: user exists, password match, etc.
        if (username.equals(password)) {
            // return success message
            response.setResponseMessage("SUCCESS")
                    .setResponseCode(0);

        } else {
            // return failure message
            response.setResponseMessage("FAILURE")
                    .setResponseCode(1);

        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside logout");

    }
}
