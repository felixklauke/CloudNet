/*
 * Copyright (c) Tarek Hosni El Alaoui 2017
 */

package de.dytanic.cloudnet.lib.network.http;

import lombok.Getter;

import java.net.URLConnection;

@Getter
public class URLBuilder implements Cloneable {

    private StringBuilder urlString = new StringBuilder();
    private StringBuilder param = new StringBuilder().append("?");

    public URLBuilder(String http, String mainUrl) {
        this.urlString.append(http).append("://").append(mainUrl).append("/");
    }

    public URLBuilder path(String path) {
        if (urlString.substring(0).endsWith("/")) {
            urlString.append(path);
        } else {
            urlString.append("/").append(path);
        }
        return this;
    }

    public URLBuilder query(String queryKey, String queryValue) {
        param.append(queryKey).append("=").append(queryValue).append("&");
        return this;
    }

    public java.net.URL url() {
        try {
            return new java.net.URL(urlString.substring(0) + param.substring(0));
        } catch (Exception ex) {
            return null;
        }
    }


    public URLConnection urlConnection() {
        try {
            return new java.net.URL(urlString.substring(0) + param.substring(0)).openConnection();
        } catch (Exception ex) {
            return null;
        }
    }

    public URLBuilder clone() {
        try {
            return (URLBuilder) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return this;
    }

}