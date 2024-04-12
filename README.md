# AWS::IAM::Role Policy Json validator

## About Project

This project implements a method for verifying input JSON data based on the AWS IAM Role Policy format. The goal of the method is to validate whether the Resource field in the input JSON conforms to specific criteria.

### Exercise: AWS IAM Role Policy Verification

The task is to implement a method that verifies input JSON data formatted as an AWS IAM Role Policy. The input JSON may be read from a file and should adhere to the AWS IAM Role JSON definition and example.

### Requirements

1. **Input JSON Format**: The input JSON data should follow the structure of an AWS IAM Role Policy, including the `PolicyDocument` and `Statement` fields.
2. **Validation Criteria**: The method should return `false` if the `Resource` field of the input JSON contains a single asterisk `*`. Otherwise, it should return `true`.
3. **Reading Input JSON**: The method should be capable of reading input JSON data from a file.

### Implementation Details

- The method will use the json-simply library to parse the input JSON file and extract the necessary fields.
- It will specifically focus on validating the `Resource` field within the `Statement` of the `PolicyDocument`.
- If the `Resource` field contains a single asterisk (`*`), the method will return `false`, indicating invalid resource usage.
- Otherwise, if the `Resource` field does not contain a single asterisk, the method will return `true`, indicating valid resource usage.

### Example Scenario

Suppose the input JSON file represents an AWS IAM Role Policy:

```json
{
  "PolicyName": "root",
  "PolicyDocument": {
    "Version": "2012-10-17",
    "Statement": [
      {
        "Sid": "IamListAccess",
        "Effect": "Allow",
        "Action": [
          "iam:ListRoles",
          "iam:ListUsers"
        ],
        "Resource": "*"
      }
    ]
  }
}
```

In this scenario, method should return false.


## Prerequisites
- Java Development Kit (JDK) version 21
- Apache Maven

## Build and run
- 1st option (IntellijIdea): Open project in IntellijIdea where you can run all tests, main function runs only task example.
- 2nd option (Maven): go to the folder with the repository and run these commands:
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.example.Main"
```
and for tests:
```bash
mvn test
```
