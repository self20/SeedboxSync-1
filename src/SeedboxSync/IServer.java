/****************************************************************************
 *
 * IServer.java
 *
 * Defines the interface for Server objects.
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

import java.util.List;
import java.io.File;

import org.apache.commons.net.ftp.FTPFile;

/**
 * Defines the interface for Server objects.
 */
public interface IServer {
    /**
     * Gets the Server address.
     * @return The Server address.
     */
    String getAddress();

    /**
     * Gets the username used when connecting to the Server.
     * @return The username used when connecting to the Server.
     */
    String getUsername();

    /**
     * Gets the password used when connecting to the Server.
     * @return The password used when connecting to the Server.
     */
    String getPassword();

    /**
     * Gets the Server port.
     * @return The Server port.
     */
    Integer getPort();

    /**
     * Opens the Server connection using the specified IP address and the default port.
     * @throws Exception Thrown if an exception is encountered during the connect or login operations.
     */
    void connect() throws Exception;

    /**
     * Restablishes the Server connection.
     * @throws Exception Thrown if an exception is encountered during the reconnect.
     */
    void reconnect() throws Exception;

    /**
     * Closes the Server connection.
     * @throws Exception Thrown if an exception is encountered during the disconnect operation.
     */
    void disconnect() throws Exception;

    /**
     * Returns a value indicating whether the Server is connected.
     * @return A value indicating whether the Server is connected.
     */
    Boolean isConnected();

    /**
     * Returns a list of files contained within the specified directory.
     * @param directory The directory for which to return the file list.
     * @return A list of files contained within the directory.
     * @throws Exception Thrown if an exception is encountered during the listFiles operation.
     */
    List<FTPFile> list(String directory) throws Exception;

    /**
     * Downloads the specified file.
     * @param sourceFile The filename of the file to download.
     * @param destinationFile The file to which the downloaded file should be saved.
     * @param size The size of the file in bytes.
     * @throws Exception Thrown if an exception is encountered during the download.
     */
    void download(String sourceFile, String destinationFile, Long size) throws Exception;

    /**
     * Downloads the specified file.
     * @param sourceFile The file to download.
     * @param destinationFile The file to which the downloaded file should be saved.
     * @param size The size of the file in bytes.
     * @return A value indicating whether the download completed successfully.
     * @throws Exception Thrown if an exception is encountered during the download.
     */
    void download(String sourceFile, File destinationFile, Long size) throws Exception;

    /**
     * Uploads the specified file.
     * @param sourceFile The filename of the file to upload.
     * @param destinationFile The destination filename.
     * @return A value indicating whether the upload completed successfully.
     * @throws Exception Thrown if an exception is encountered during the upload.
     */
    void upload(String sourceFile, String destinationFile) throws Exception;

    /**
     * Uploads the specified file.
     * @param sourceFile The file to upload.
     * @param destinationFile The destination filename.
     * @return A value indicating whether the upload completed successfully.
     * @throws Exception Thrown if an exception is encountered during the upload.
     */
    void upload(File sourceFile, String destinationFile) throws Exception;
}
