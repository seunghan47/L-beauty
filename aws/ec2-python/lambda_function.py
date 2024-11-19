import boto3


def lambda_handler(event, context):
    instance_id = "i-05cc78120cdcb8d6e"
    region = "us-east-1"

    try:
        ec2 = boto3.client('ec2', region_name=region)
        response = ec2.start_instances(InstanceIds=[instance_id])
        return {
            "statusCode": 200,
            "body": f"Instance started: {instance_id}",
            "response": response
        }
    except Exception as e:
        return {
            "statusCode": 500,
            "error": str(e)
        }
