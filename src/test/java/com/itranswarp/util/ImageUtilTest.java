package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

import com.itranswarp.bean.ImageBean;
import com.itranswarp.common.ApiException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ImageUtilTest {

    static Stream<Object[]> imageParameters() {
        return Stream.of(
                new Object[] {"/400x320.jpg", 400, 320, "image/jpeg"},
                new Object[] {"/400x320.png", 400, 320, "image/png"},
                new Object[] {"/400x320.gif", 400, 320, "image/gif"}
        );
    }

    @ParameterizedTest
    @MethodSource("imageParameters")
    void testReadImage(String filePath, int expectedWidth, int expectedHeight, String expectedMimeType) throws IOException {
        byte[] data = IOUtil.readAsBytes(getClass().getResourceAsStream(filePath));
        ImageBean bean = ImageUtil.readImage(data);

        assertNotNull(bean.image);
        assertEquals(expectedWidth, bean.width);
        assertEquals(expectedHeight, bean.height);
        assertEquals(expectedMimeType, bean.mime);
    }

    @Test
    void testReadImageAsBmp() throws IOException {
        byte[] data = IOUtil.readAsBytes(getClass().getResourceAsStream("/test.bmp"));
        assertThrows(ApiException.class, () -> {
            ImageUtil.readImage(data);
        });
    }

    @Test
    void testReadImageAsWebp() throws IOException {
        byte[] data = IOUtil.readAsBytes(getClass().getResourceAsStream("/test.webp"));
        assertThrows(ApiException.class, () -> {
            ImageUtil.readImage(data);
        });
    }

    @Test
    void testCreateThumbWithSameWidth() throws IOException {
        BufferedImage input = ImageIO.read(getClass().getResourceAsStream("/400x320.jpg"));
        BufferedImage output = ImageUtil.resizeKeepRatio(input, 400);
        assertSame(output, input);
    }

    @Test
    void testCreateThumbWithLargerWidth() throws IOException {
        BufferedImage input = ImageIO.read(getClass().getResourceAsStream("/400x320.jpg"));
        BufferedImage output = ImageUtil.resizeKeepRatio(input, 420);
        assertSame(output, input);
    }

    @Test
    void testCreateThumbWithHalfWidth() throws IOException {
        BufferedImage input = ImageIO.read(getClass().getResourceAsStream("/400x320.jpg"));
        BufferedImage output = ImageUtil.resizeKeepRatio(input, 200);
        assertEquals(200, output.getWidth());
        assertEquals(160, output.getHeight());
        String base64 = ImageUtil.encodeJpegAsBase64(output);
        System.out.println("<img src=\"data:image/jpeg;base64," + base64 + "\" />");
    }

    @Test
    void testCreateThumbWithSmallWidth() throws IOException {
        BufferedImage input = ImageIO.read(getClass().getResourceAsStream("/400x320.png"));
        BufferedImage output = ImageUtil.resizeKeepRatio(input, 40);
        assertEquals(40, output.getWidth());
        assertEquals(32, output.getHeight());
        String base64 = ImageUtil.encodeJpegAsBase64(output);
        System.out.println("<img src=\"data:image/jpeg;base64," + base64 + "\" />");
    }

    @Test
    void testCreateThumbWithSmallWidth2() throws IOException {
        BufferedImage input = ImageIO.read(getClass().getResourceAsStream("/400x320.gif"));
        BufferedImage output = ImageUtil.resizeKeepRatio(input, 40);
        assertEquals(40, output.getWidth());
        assertEquals(32, output.getHeight());
        String base64 = ImageUtil.encodeJpegAsBase64(output);
        System.out.println("<img src=\"data:image/jpeg;base64," + base64 + "\" />");
    }

}
