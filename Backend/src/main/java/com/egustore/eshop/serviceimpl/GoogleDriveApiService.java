package com.egustore.eshop.serviceimpl;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Objects;

@Service
public class GoogleDriveApiService {

    private static final String APPLICATION_NAME = "Web EGU Store";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private Drive drive;

    public GoogleDriveApiService() {
        try {
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            drive = new Drive.Builder(httpTransport, JSON_FACTORY, getCredentials(httpTransport))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Credential getCredentials(final HttpTransport httpTransport) throws IOException {
        InputStreamReader clientSecretReader = new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream("/client_secret.json")));
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, clientSecretReader);

        AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets,
                Collections.singletonList(DriveScopes.DRIVE_FILE))
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8080).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public String uploadImageToGoogleDrive(MultipartFile file, String folderId) throws IOException {
            File driveFile = new File();
            driveFile.setName(file.getOriginalFilename());
            driveFile.setParents(Collections.singletonList(folderId)); // Thiết lập parentId của thư mục cố định

            FileContent mediaContent = new FileContent("image/jpeg", convertMultiPartToFile(file));

            Drive.Files.Create createFile = drive.files().create(driveFile, mediaContent)
                    .setFields("id, webContentLink");

             File uploadedFile = createFile.execute();

            String viewLink = uploadedFile.getWebContentLink().replace("&export=download", "&export=view");

            return viewLink;
    }
    private java.io.File convertMultiPartToFile(MultipartFile file) throws IOException {
        java.io.File convFile = java.io.File.createTempFile("uploadedFile", ".jpg");
        file.transferTo(convFile);
        return convFile;
    }

}