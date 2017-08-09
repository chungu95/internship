package project_management.api;

public class WebURL {
    private static final String WEB_URL = "";
    private static final String REST_URL = "api/";

    public static class USER {
        public static final String LOGIN_PAGE = "/login";
        public static final String ADD_NEW_USER = "/add-user";
        public static final String CHECK_EXISTED_USER = "/check-existed-user";
    }

    public static class EMPLOYEE {
        public static final String CREATE_NEW_EMPLOYEE = "/add-new-employee";
        public static final String CREATE_NEW_EMPLOYEE_PAGE = "/add-employee";
        public static final String ALL_EMPLOYEE_PAGE = "/preview-all-employees";
        public static final String EDIT_EMPLOYEE_PAGE = "/edit-employee/{empId}";
        public static final String UPDATE_EMPLOYEE = "/update-employee";
        public static final String DELETE_EMPLOYEE = "/delete-employee/{empId}";
    }

    public static class PROJECT {
        public static final String ALL_PROJECTS_PAGE = "all-projects";
        public static final String ADD_NEW_PROJECT_PAGE = "add-new-project";
        public static final String ADD_NEW_PROJECT = "add-project";
    }
}
