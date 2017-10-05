/*
 * Copyright 2014-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bluebreezecf.tools.sparkjobserver.api;

/**
 * Presents the information of spark job jar files, when
 * calling <code>GET /jars</code> to a spark job server.
 * 
 * @author bluebreezecf
 * @since 2014-09-11
 *
 */
public class SparkJobBinaryInfo {
	private static final String INFO_EMPTY_VALUE = "empty value";
	static final String INFO_KEY_NAME = "name";
	static final String INFO_BINARY_TYPE = "type";
	static final String INFO_KEY_UPLOADED_TIME = "uploadedTime";
	
	private String name;
	private String uploadedTime;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUploadedTime() {
		return uploadedTime;
	}
	public void setUploadedTime(String uploadedTime) {
		this.uploadedTime = uploadedTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("SparkJobJarInfo{\n");
		buff.append(" ").append(INFO_KEY_NAME).append(": ")
		    .append(this.getName() != null ? this.getName() : INFO_EMPTY_VALUE).append(",\n");
		buff.append(" ").append(INFO_BINARY_TYPE).append(": ")
				.append(this.getName() != null ? this.getName() : INFO_EMPTY_VALUE).append(",\n");
		buff.append(" ").append(INFO_KEY_UPLOADED_TIME).append(": ")
	    	.append(this.getUploadedTime() != null ? this.getUploadedTime() : INFO_EMPTY_VALUE).append('\n');
		buff.append("}");
		return buff.toString();
	}
}
