package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.StopInstancesRequest;

public class StopEC2Instance {
    public String handleRequest(Object input, Context context) {

        String instanceId = "i-05cc78120cdcb8d6e";
        String region = "us-east-1";

        try (
            Ec2Client ec2 = Ec2Client.builder().region(software.amazon.awssdk.regions.Region.of(region)).build()) {
            StopInstancesRequest request = StopInstancesRequest.builder()
                    .instanceIds(instanceId)
                    .build();
            ec2.stopInstances(request);
            return "Instance stopped: " + instanceId;
        } catch (Exception e) {
            return "Error stopping instance: " + e.getMessage();
        }
    }
}