package com.deswaef.shadowfury;


import com.google.gson.Gson;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AbstractMockedTest {

    private Gson gson;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        this.gson = new Gson();
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }

    public String readJsonFile(String s) throws IOException {
        URL url = this.getClass().getResource(s);
        File testProperties = new File(url.getFile());
        return readFile(URLDecoder.decode(testProperties.getPath()), Charset.defaultCharset());
    }

    public String apiKey() throws IllegalArgumentException {
        try {
            return gson.fromJson(readJsonFile("/battlenet/api/apikey.json"), APIKey.class).getApikey();
        } catch (Exception ex) {
            throw new IllegalArgumentException("make sure you added an apikey.json file to your battlenet/api classpath");
        }
    }


    public void setField(Object theObject, String fieldName, String value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = theObject.getClass();
        Field fieldToSet = clazz.getDeclaredField(fieldName);
        fieldToSet.setAccessible(true);
        fieldToSet.set(theObject, value);
    }

    static class APIKey {
        private String apikey;

        public String getApikey() {
            return apikey;
        }
    }

}
