package br.com.zup.godfather.agent;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public class ServletHelper {

    public ServletHelper() {
    }

    public void trace(InputStream inputStream) {
        try {
            String content = convert(inputStream, Charset.defaultCharset());
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String convert(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) > -1) {
            baos.write(buffer, 0, len);
        }
        baos.flush();
        InputStream is1 = new ByteArrayInputStream(baos.toByteArray());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is1, charset))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
