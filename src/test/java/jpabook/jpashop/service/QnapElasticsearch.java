package jpabook.jpashop.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class QnapElasticsearch {
    public static void main(String[] args) throws Exception {
        // KeyStore에 인증서를 로드합니다.
        KeyStore keyStore = KeyStore.getInstance("JKS");
        FileInputStream fileInputStream = new FileInputStream("C:/Users/psyde/OneDrive/문서/SSL_all/SSLcertificate.crt");
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);
        keyStore.load(null, "certificate_password".toCharArray());
        keyStore.setCertificateEntry("alias", certificate);

// SSL 소켓을 생성합니다.
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("psydev.asuscomm.com", 59101);
        sslSocket.startHandshake();

// SSL 소켓을 사용하여 통신합니다.
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sslSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        writer.write("GET / HTTP/1.1\r\n");
        writer.write("Host: psydev.asuscomm.com\r\n");
        writer.write("\r\n");
        writer.flush();
        String response = reader.readLine();
        System.out.println("Server response: " + response);
    }
}