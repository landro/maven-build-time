package org.apache.maven.cli;

import org.apache.maven.cli.event.ExecutionEventLogger;
import org.apache.maven.execution.ExecutionEvent;
import org.apache.maven.plugin.MojoExecution;
import org.slf4j.Logger;

public class ExecutionTimingExecutionListener extends ExecutionEventLogger {

    private long starttime;
    private final Logger logger;

    public ExecutionTimingExecutionListener(final Logger logger) {
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
        logger.info("ExecutionTime " + event.getProject().getArtifactId() + " " + me.getGroupId() + " " + me.getArtifactId() + " "
                + me.getGoal() + " executed in " + (System.currentTimeMillis() - starttime) + " ms");

    }
}
