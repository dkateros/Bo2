package gr.interamerican.bo2.impl.open.job;

import gr.interamerican.bo2.arch.Operation;

import java.util.Map;

/**
 * 
 */
public interface JobDescription {

	/**
	 * Gets the operationClass.
	 *
	 * @return Returns the operationClass
	 */
	Class<?> getOperationClass();

	/**
	 * Assigns a new value to the operationClass.
	 *
	 * @param operationClass the operationClass to set
	 */
	void setOperationClass(Class<? extends Operation> operationClass);

	/**
	 * Gets the parameters.
	 *
	 * @return Returns the parameters
	 */
	Map<String, Object> getParameters();

	/**
	 * Assigns a new value to the parameters.
	 *
	 * @param parameters the parameters to set
	 */
	void setParameters(Map<String, Object> parameters);

	/**
	 * Gets the executionStatus.
	 *
	 * @return Returns the executionStatus
	 */
	JobStatus getExecutionStatus();

	/**
	 * Assigns a new value to the executionStatus.
	 *
	 * @param executionStatus the executionStatus to set
	 */
	void setExecutionStatus(JobStatus executionStatus);

	/**
	 * Gets the jobName.
	 *
	 * @return Returns the jobName
	 */
	String getJobName();

	/**
	 * Assigns a new value to the jobName.
	 *
	 * @param jobName the jobName to set
	 */
	void setJobName(String jobName);

}