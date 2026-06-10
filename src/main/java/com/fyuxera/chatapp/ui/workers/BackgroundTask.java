package com.fyuxera.chatapp.ui.workers;

import javax.swing.*;

/**
 * Background Task - Abstract class for background operations
 * Use this for login/register operations with progress dialog
 * @author Sanod
 */
public abstract class BackgroundTask extends SwingWorker<Boolean, String> {
    
    private final JFrame parentFrame;
    private final String taskName;
    
    public BackgroundTask(JFrame parentFrame, String taskName) {
        this.parentFrame = parentFrame;
        this.taskName = taskName;
    }
    
    /**
     * Implement this method with actual work
     * Return true for success, false for failure
     */
    protected abstract Boolean performTask() throws Exception;
    
    /**
     * Handle success - override if needed
     */
    protected void onSuccess() {
        // Override in subclass
    }
    
    /**
     * Handle failure - override if needed
     */
    protected void onFailure(Exception e) {
        // Override in subclass
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
        try {
            Boolean result = performTask();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    protected void done() {
        try {
            Boolean result = get();
            if (result != null && result) {
                onSuccess();
            } else {
                onFailure(new Exception("Task returned false"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            onFailure(e);
        }
    }
}
