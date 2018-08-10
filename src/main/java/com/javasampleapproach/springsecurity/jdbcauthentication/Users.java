package com.javasampleapproach.springsecurity.jdbcauthentication;

public class Users {

        private String username;
        private String password;

        public String getUsernameame(){
            return username;
        }

        public void setUsername(String username){
            this.username = username;
        }

        public String getPassword(){
            return password;
        }

    public void setPassword(String password) {
        this.password = password;
    }
}
