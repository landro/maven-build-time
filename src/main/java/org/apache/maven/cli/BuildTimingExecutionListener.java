package org.apache.maven.cli;

import org.apache.maven.execution.ExecutionEvent;
import org.apache.maven.plugin.MojoExecution;
import org.codehaus.plexus.logging.Logger;

public class BuildTimingExecutionListener extends ExecutionEventLogger {

	private long starttime;
	private final Logger logger;

	public BuildTimingExecutionListener(final Logger logger) {
		super(logger);
		this.logger = logger;
	}

	@Override
	public void mojoStarted(final ExecutionEvent event) {
		starttime = System.currentTimeMillis();
		super.mojoStarted(event);
	}

	@Override
	public void mojoSucceeded(final ExecutionEvent event) {

		MojoExecution me = event.getMojoExecution();
		logger.info("BuildTime " + event.getProject().getArtifactId() + " " + me.getGroupId() + " " + me.getArtifactId() + " "
				+ me.getGoal() + " executed in (ms) " + (System.currentTimeMillis() - starttime));

	}
}
