package com.liferay.scheduled.jobs;

import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class MyScheduledJob: A scheduled job using the new Job Scheduler Framework.
 *
 * @author dnebinger
 */
@Component(
        immediate = true,
        property = {
                "dispatch.task.executor.name=My Scheduled Job",
                "dispatch.task.executor.type=dnebing.job-01"
        },
        service = DispatchTaskExecutor.class
)
public class MyScheduledJob extends BaseDispatchTaskExecutor {
    /**
     * doExecute: Invoked to complete the work of the scheduled task.
     * @param dispatchTrigger Trigger for the scheduled job.
     * @param dispatchTaskExecutorOutput Used to send details for an admin to
     *                                   review for job status.
     * @throws Exception in case of failure.
     */
    @Override
    public void doExecute(DispatchTrigger dispatchTrigger,
                          DispatchTaskExecutorOutput dispatchTaskExecutorOutput) throws Exception {
        _log.info("Scheduled task executed...");

        UnicodeProperties props = dispatchTrigger.getDispatchTaskSettingsUnicodeProperties();

        dispatchTaskExecutorOutput.setOutput("Scheduled task executed successfully.");

        if (props != null) {
            if (GetterUtil.getBoolean(props.getProperty("log.alternate.message"), false)) {
                dispatchTaskExecutorOutput.setOutput("<p>This is html output.</p><p>It contains multiple lines &amp; html characters.</p><table border=\"1\" cellspacing='1' cellpadding='2'><tr><td>cell 1</td><td>cell 2</td></tr></table><p>Listing:<br /><ul><li>Item 1</li><br /><li>Item 2</li></ul></p>");
                dispatchTaskExecutorOutput.setError("This is generated error text.");
            }
        }
    }

    /**
     * getName: Returns the name for the scheduled job.
     * @return String The name for the job, can be a message key for a resource
     * bundle.
     */
    @Override
    public String getName() {
        return "My Scheduled Job";
    }

    private static final Logger _log = LoggerFactory.getLogger(MyScheduledJob.class);
}
