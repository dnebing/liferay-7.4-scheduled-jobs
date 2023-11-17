# Liferay 7.4 Job Scheduler

This is the repo that I used to build and test the job scheduler.

I tested this using DXP 7.4 U92, although it should work for any 7.4
release (CE or DXP), including the new DXP Quarterly releases.

Build and deploy the scheduled-job module to your environment,
then navigate to the Control Panel -> Job Scheduler and add a new job.

In the dropdown list (you may have to hit "Show All"), you should find "My Scheduled Job".

When you select it, just give it a name and you can save and then click the "Run Now" button.

In the properties, you could set `log.alternate.message=true` to see the
alternate log message and to demonstrate properties for job control.

See the blog at https://liferay.dev/blogs/-/blogs/liferay-7-4-scheduled-tasks

Enjoy!