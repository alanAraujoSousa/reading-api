package com.hivecloud.reading.constants;

public abstract class EndPointsV1 {

    public static class USER {
        public static final String ROOT = "/v1/user";
        public static final String GET = "/{id}";
        public static final String PROFILE = "/profile";
        public static final String CREATE = "/signup";
    }

    public static class BOOK {
        public static final String ROOT = "/v1/book";
        public static final String GET = "/{id}";
        public static final String READING = "/{id}/reading";
        public static final String READ = "/{id}/read";
    }
}