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
    }

    public static class PROJECT {
        public static final String GET_ALL_PROJECTS = "all-projects";
    }
}
