/* 
 * MIT License
 * 
 * Copyright (c) 2018 Guillermo Facundo Colunga
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.weso.security.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

/**
 * The Class DynamoDBConfig.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
@Configuration
@EnableDynamoDBRepositories(basePackages = "org.weso.security.repositories")
public class DynamoDBConfig {

	/** The amazon dynamo DB endpoint. */
	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;

	/** The amazon AWS access key. */
	@Value("${amazon.aws.accesskey}")
	private String amazonAWSAccessKey;

	/** The amazon AWS secret key. */
	@Value("${amazon.aws.secretkey}")
	private String amazonAWSSecretKey;

	/**
	 * Amazon dynamo DB.
	 *
	 * @return the amazon dynamo DB
	 */
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient( amazonAWSCredentials() );

		if (!StringUtils.isEmpty( amazonDynamoDBEndpoint )) {
			amazonDynamoDB.setEndpoint( amazonDynamoDBEndpoint );
		}

		return amazonDynamoDB;
	}

	/**
	 * Amazon AWS credentials.
	 *
	 * @return the AWS credentials
	 */
	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(
				amazonAWSAccessKey, amazonAWSSecretKey );
	}
}
