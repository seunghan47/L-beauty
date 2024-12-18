package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;

public class StartEC2Instance {
    public String handleRequest(Object input, Context context) {
        String instanceId = "i-05cc78120cdcb8d6e";
        String instanceRegion = "us-east-1";

        try (Ec2Client ec2 = Ec2Client.builder().region(software.amazon.awssdk.regions.Region.of(instanceRegion)).build()) {
            StartInstancesRequest request = StartInstancesRequest.builder()
                    .instanceIds(instanceId)
                    .build();
            ec2.startInstances(request);
            return "Instance started: " + instanceId;
        } catch (Exception e) {
            return "Error starting instance: " + e.getMessage();
        }
    }
}
