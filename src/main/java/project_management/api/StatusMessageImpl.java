package project_management.api;

import org.springframework.stereotype.Service;

@Service("statusMessage")
public class StatusMessageImpl implements StatusMessage{

    @Override
    public project_management.common.model.StatusMessage success() {
        return project_management.common.model.StatusMessage.SUCCESS;
    }

    @Override
    public project_management.common.model.StatusMessage fail() {
        return project_management.common.model.StatusMessage.FAIL;
    }
}
