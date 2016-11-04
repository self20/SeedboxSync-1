/****************************************************************************
 *
 * Configuration.java
 *
 * Represents the application Configuration models.
 *
 ***************************************************************************
 *
 * Copyright (C) 2016 JP Dillingham (jp@dillingham.ws)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 ****************************************************************************/

/**
 * Represents the application Configuration model.
 */
public class Configuration {
    /**
     * The configured server address.
     */
    private String server;

    /**
     * The configured server port.
     */
    private Integer port;

    /**
     * The configured username for the server.
     */
    private String username;

    /**
     * The configured password for the server.
     */
    private String password;

    /**
     * The configured interval on which the synchronization should take place.
     */
    private Integer interval;

    /**
     * The configured remote directory which is to be synchronized.
     */
    private String remoteDownloadDirectory;

    /**
     * The configured local directory to which files are to be downloaded.
     */
    private String localDownloadDirectory;

    /**
     * The configured remote directory to which synchronized files are to be uploaded.
     */
    private String remoteUploadDirectory;

    /**
     * The configured local directory from which files are uploaded.
     */
    private String localUploadDirectory;

    /**
     * Initializes a new instance of the Configuration class with the specified parameters.
     * @param server The server address.
     * @param port The server port.
     * @param username The username for the server.
     * @param password The password for the server.
     * @param interval The interval on which synchronization should take place.
     * @param remoteDownloadDirectory The remote directory which is to be synchronized.
     * @param localDownloadDirectory The local directory to which files are to be downloaded.
     * @param remoteUploadDirectory The remote directory to which synchronized files are to be uploaded.
     * @param localUploadDirectory The local directory from which files are to be uploaded.
     */
    public Configuration(String server, Integer port, String username, String password, Integer interval, String remoteDownloadDirectory, String localDownloadDirectory, String remoteUploadDirectory, String localUploadDirectory) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.password = password;
        this.interval = interval;
        this.remoteDownloadDirectory = remoteDownloadDirectory;
        this.localDownloadDirectory = localDownloadDirectory;
        this.remoteUploadDirectory = remoteUploadDirectory;
        this.localUploadDirectory = localUploadDirectory;
    }

    /**
     * Gets the configured server address.
     * @return The configured server address.
     */
    public String getServer() {
        return server;
    }

    /**
     * Gets the configured server port.
     * @return The configured server port.
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Gets the configured username for the server.
     * @return The configured username for the server.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the configured password for the server.
     * @return The configured password for the server.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the configured interval on which the synchronization should take place.
     * @return The configured interval on which the synchronization should take place.
     */
    public Integer getInterval() {
        return interval;
    }

    /**
     * Gets the remote directory which is to be synchronized.
     * @return The remote directory which is to be synchronized.
     */
    public String getRemoteDownloadDirectory() {
        return remoteDownloadDirectory;
    }

    /**
     * Gets the local directory to which files are to be downloaded.
     * @return The local directory to which files are to be downloaded.
     */
    public String getLocalDownloadDirectory() {
        return localDownloadDirectory;
    }

    /**
     * Gets the remote directory to which files are uploaded.
     * @return The remote directory to which files are uploaded.
     */
    public String getRemoteUploadDirectory() { return remoteUploadDirectory; }

    /**
     * Gets the local directory from which files are uploaded.
     * @return The local directory from which files are uploaded.
     */
    public String getLocalUploadDirectory() { return localUploadDirectory; }

    /**
     * Returns a value indicating whether the configuration is valid.
     * @return A value indicating whether the configuration is valid.
     */
    public Boolean isValid() {
        String err = "";

        if (server == null || server == "") {
            err = "Server is missing or blank.";
        }
        else if (port == null || port <= 0) {
            err = "Server port is null or invalid.";
        }
        else if (username == null || username == "") {
            err = "Username is missing or blank.";
        }
        else if (password == null) {
            err = "Password is missing.";
        }
        else if (interval == null || interval <= 0) {
            err = "Interval is missing or too low.";
        }
        else if (remoteDownloadDirectory == null || remoteDownloadDirectory == "") {
            err = "Remote download directory is missing or blank.";
        }
        else if (localDownloadDirectory == null || localDownloadDirectory == "") {
            err = "Local download directory is missing or blank.";
        }
        else if (remoteUploadDirectory == null || remoteUploadDirectory == "") {
            err = "Remote upload directory is missing or blank.";
        }
        else if (localUploadDirectory == null || localUploadDirectory == "") {
            err = "Local upload directory is missing or blank.";
        }

        if (err != "") {
            return false;
        }

        return true;
    }
}