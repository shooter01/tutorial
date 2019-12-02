package main.java.java8.helpers;

import java.util.Date;
import java.util.List;

public class LogEntry {
    Date date;
    String login;
    String url;

    public LogEntry(Date date, String login, String url) {
        this.date = date;
        this.login = url;
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "date=" + date +
                ", login='" + login + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
