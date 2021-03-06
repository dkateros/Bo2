/*******************************************************************************
 * Copyright (c) 2013 INTERAMERICAN PROPERTY AND CASUALTY INSURANCE COMPANY S.A. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/copyleft/lesser.html
 * 
 * This library is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 ******************************************************************************/
package gr.interamerican.bo2.impl.open.utils;

import gr.interamerican.bo2.arch.enums.TargetEnvironment;
import gr.interamerican.bo2.utils.Debug;
import gr.interamerican.bo2.utils.Utils;
import gr.interamerican.bo2.utils.beans.PropertiesInitializedBean;

import java.util.Properties;

/**
 * Bean with the properties of the current Bo2 deployment.
 */
public class Bo2DeploymentParams 
extends PropertiesInitializedBean {

	/**
	 * Creates a new Bo2DeploymentParams object. 
	 *
	 * @param properties the properties
	 */
	public Bo2DeploymentParams(Properties properties) {
		super(properties);
	}
	
	/**
	 * {@link Debug} enablement.
	 */
	private Boolean debugEnabled;
	
	/**
	 * {@link TargetEnvironment}.
	 */
	private TargetEnvironment targetEnvironment;
	
	/**
	 * Controls whether the stackTrace is shown in
	 * the error panel.
	 */
	private Boolean showStackTraceInWebPages;
	
	/** path To Default Factory Mappings. */
	private String pathToDefaultFactoryDefinition;
	
	/**
	 * path to default panel factory mappings.
	 */
	private String pathToDefaultPanelFactoryDefinition;
	
	/**
	 * path to the list of managers definitions.
	 */
	private String pathToManagersList;
	
	/**
	 * path to the properties file with manager aliases.
	 */
	private String pathToManagerAliases;
	
	/**
	 * path to the list of classes that are loaded immediately.
	 */
	private String pathToPreLoadClasses;

	/**
	 * Short date format.
	 */
	private String shortDateFormat;
	
	/**
	 * Long date format.
	 */
	private String longDateFormat;
	
	/**
	 * name of default resource manager for streams used by AbstractRuntimeCommands.
	 */
	private String streamsManagerName;
	
	/** name of default resource manager for scheduling jobs. */
	private String schedulerManagerName;
	
	/**
	 * Class name of TransactionManager.
	 */
	private String transactionManagerClass;
	
	/**
	 * Temporary directory.
	 */
	private String tempDir;
	
	/**
	 * Encoding of text files accessed from the filesystem. 
	 */
	private String textEncoding;
	
	/**
	 * Encoding of text files accessed from jars.
	 */
	private String resourceFileEncoding;
	
	/**
	 * Name of this Bo2 application.
	 */
	private String applicationName;
	
	/**
	 * Gets the debugEnabled.
	 *
	 * @return Returns the debugEnabled
	 */
	public Boolean getDebugEnabled() {
		return debugEnabled;
	}

	/**
	 * Gets the targetEnvironment.
	 *
	 * @return Returns the targetEnvironment
	 */
	public TargetEnvironment getTargetEnvironment() {
		return Utils.notNull(targetEnvironment, TargetEnvironment.DEVELOPMENT);
	}

	/**
	 * Gets the shortDateFormat.
	 *
	 * @return Returns the shortDateFormat
	 */
	public String getShortDateFormat() {
		return shortDateFormat;
	}

	/**
	 * Gets the longDateFormat.
	 *
	 * @return Returns the longDateFormat
	 */
	public String getLongDateFormat() {
		return longDateFormat;
	}

	/**
	 * Path to the properties file that contains the definition of the
	 * default object factory.
	 * 
	 * @return Returns the path to the definition of the default object
	 *         factory.
	 */
	public String getPathToDefaultFactoryDefinition() {
		return pathToDefaultFactoryDefinition;
	}
	

	/**
	 * Path to the text file that contains the list of resource managers
	 * definitions.
	 * 
	 * @return Returns the path to the definitions of resource managers.
	 */
	public String getPathToManagersList() {
		return pathToManagersList;
	}

	/**
	 * Gets the name of the default streamsManager.
	 *
	 * @return Returns the streamsManagerName
	 */
	public String getStreamsManagerName() {
		return streamsManagerName;
	}

	/**
	 * Gets the schedulerManagerName.
	 *
	 * @return Returns the schedulerManagerName
	 */
	public String getSchedulerManagerName() {
		return schedulerManagerName;
	}

	/**
	 * Gets the pathToPreLoadClasses.
	 *
	 * @return Returns the pathToPreLoadClasses
	 */
	public String getPathToPreLoadClasses() {
		return pathToPreLoadClasses;
	}

	/**
	 * Gets the transactionManagerClass.
	 *
	 * @return Returns the transactionManagerClass
	 */
	public String getTransactionManagerClass() {
		return transactionManagerClass;
	}

	/**
	 * Gets the pathToManagerAliases.
	 * 
	 * @return Returns the path to the manager aliases properties file.
	 */
	public String getPathToManagerAliases() {
		return pathToManagerAliases;
	}

	/**
	 * Gets the pathToDefaultPanelFactoryDefinition.
	 * 
	 * @return Returns the path to the default panel factory mappings
	 *         properties file.
	 */
	public String getPathToDefaultPanelFactoryDefinition() {
		return pathToDefaultPanelFactoryDefinition;
	}

	/**
	 * Gets the showStackTraceInWebPages.
	 *
	 * @return Returns the showStackTraceInWebPages
	 */
	public Boolean getShowStackTraceInWebPages() {
		return showStackTraceInWebPages;
	}

	/**
	 * Assigns a new value to the showStackTraceInWebPages.
	 *
	 * @param showStackTraceInWebPages the showStackTraceInWebPages to set
	 */
	public void setShowStackTraceInWebPages(Boolean showStackTraceInWebPages) {
		this.showStackTraceInWebPages = showStackTraceInWebPages;
	}

	/**
	 * Gets the tempDir.
	 *
	 * @return Returns the tempDir
	 */
	public String getTempDir() {
		return tempDir;
	}

	/**
	 * Assigns a new value to the tempDir.
	 *
	 * @param tempDir the tempDir to set
	 */
	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	/**
	 * Gets the textEncoding.
	 *
	 * @return Returns the textEncoding
	 */
	public String getTextEncoding() {
		return textEncoding;
	}

	/**
	 * Assigns a new value to the textEncoding.
	 *
	 * @param textEncoding the textEncoding to set
	 */
	public void setTextEncoding(String textEncoding) {
		this.textEncoding = textEncoding;
	}

	/**
	 * Gets the resourceFileEncoding.
	 *
	 * @return Returns the resourceFileEncoding
	 */
	public String getResourceFileEncoding() {
		return resourceFileEncoding;
	}

	/**
	 * Assigns a new value to the resourceFileEncoding.
	 *
	 * @param resourceFileEncoding the resourceFileEncoding to set
	 */
	public void setResourceFileEncoding(String resourceFileEncoding) {
		this.resourceFileEncoding = resourceFileEncoding;
	}

	/**
	 * Gets the applicationName.
	 *
	 * @return Returns the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * Assigns a new value to the applicationName.
	 *
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
}
