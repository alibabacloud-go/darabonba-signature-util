package com.aliyun.darabonba.signature;

import com.aliyun.darabonba.encode.Encoder;

import org.junit.Assert;
import org.junit.Test;

public class SignerTest {

    @Test
    public void HmacSHA1SignTest() throws Exception {
        String stringToSign = "abc~!@#";
        String sk = "sk#$!~~~";
        byte[] signed = Signer.HmacSHA1Sign(stringToSign, sk);
        Assert.assertEquals("7eV3A584uvdgKVk8Ck8r9ukg1gE=", Encoder.base64EncodeToString(signed));
    }

    @Test
    public void HmacSHA256SignTest() throws Exception {
        String stringToSign = "abcdefg";
        String sk = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDk4WyBF8Cj9JVK7ua6nuVfXt2AWdfvhpfSTznM+Dg8m"
                + "4jQwe6OzJV+UkTrY12ugWJuCXdrzyzV4jHScQaazDaS6AQZt2/6zZZT8MdO6632W/elCiv2oglFpZ8y/j5BSeGQrYZlHfb"
                + "2wz38Whko0fgKPA9ff7uS4u+8oMU5XgxhxJddWrh3dO24GVo9lX87NGDjDgQbXQ1E4CeArKmFYHJlngn/cKt1CcpiR67O/9"
                + "V/ja1wKJylUyYCvmd8k29efspse2/BHZ+zk/qlHPsAjxhTfLIkqmup0+tc0DwLuv1uMbBgJPQ15GCGPAw1ky9qay/ynXjj8"
                + "iZNcDyMfKvm6BNJAgMBAAECggEAc7aX8af9h6aGt8ySL7VXh2DhoRtK9VjZdsUBFuRDIjkL8WaqYd2Cksuq9kpVOX1GMxVs"
                + "H8AtDbD+uULVMPufd6P/NrUr0uOPZb6sNPUoDQ4v5GuBEH6ZK3HxS4mIFd/xPwDLmmGM0vKgau1uHNoSibIVn5VnUnqS841"
                + "gSIGIxv/1HI3q2/lPM7nCiTRP8iRlfousQOmmZVm+6h1DKSBaiCe+HZBwLA5IpLzz9XQ4f2N9quaMqp5I6q8pdbIWpL/KXX"
                + "rD1Y7qnZyCgEWaiqLOeoxeNtqRF/BFllXTbvGITm7QrGh5lQoeX2cmYXQQ7j+ohJ2Q+j0H2ffB0VnYgaw0BQKBgQD5badIq"
                + "7Asy367qjhv3q/ygoD+7EhQdNnQ9adN0sm0ecy0CUYqqxAxlCUddC8wEF445dw37wbOcvZoP7ogzMRivHhcTTISHmX12YAv"
                + "umFImUYahcx5ae/Mu6z0r/o+/a1XLwikKxfhEojpMRLJm/OkgmGJx1IkhPM+mxim+X6kXwKBgQDq6S35izCRIs4jJWbs7ct"
                + "6ghMXRlKnomodffwtVAlV1ZwdL3QJoMgmaE3A0Ko7E0GeoX3SoIiA79veSRlHeEwOINsJARGO3Hp0mzaZEN8f4PJyaoOrx9"
                + "PCO2aP9TFFELFapIbmH800nBL2Mxii65FiOTao9wsoD1e6oR+UX1UpVwKBgQDwP5tSlvShoPyYHDQyJOeKigNgCAz7WiH3c"
                + "LZOcosQSAVRIGGydYSqjIxXW3KcNBfdbCH6ykPfFMKc1U0djL5YcDrqhPyGkTsaW/5pend76w6oO1ohVFXC+L52DQ7YH5YY"
                + "FNiY8F0W0LiJDFiRUqKSQXdbs14+iMSW9+L96fD+twKBgEItxPz7YIhS1N4D6HYxG9T8liJFdn2xfNGoL4YZmbOrxRpXxwn"
                + "7WMexNM5wOrT/3Mmy1z6iaTJh4IBD+bIvysVkLjDgMzEbHgiBvaTrouBZQBRJu6SGXDro/yDpQ6Mga8aMeVCVfvsmSRVBGd"
                + "y0HrYcRjDdwC/d+qoiQEJNhTFrAoGBAJqc15i8tlEVjU45uWmJs+mpG6x365MGsC7q9yZ31xUCCx1lwZSlidmaY19q+wGJK"
                + "iYSz/4+KyWuOdRaFbWY/Y4jq7lVinc1S1OR8yqOSyCiYIJaDYHbPsMdZ9twX0aY/QkN+O9RyGnwL4Lmbkt/lry+OyC1vZEF"
                + "SNzdR5kSfNvY";
        String expectString = "7070fc618be1a3bae79889f6c8edd47c6c6054c9dcee92b9228a6787ca3729e2";
        byte[] signed = Signer.HmacSHA256Sign(stringToSign, sk);
        Assert.assertEquals(expectString, Encoder.hexEncode(signed));
    }

    @Test
    public void HmacSM3SignTest() throws Exception {
        String stringToSign = "abcdefg";
        String sk = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDk4WyBF8Cj9JVK7ua6nuVfXt2AWdfvhpfSTznM+Dg8m"
                + "4jQwe6OzJV+UkTrY12ugWJuCXdrzyzV4jHScQaazDaS6AQZt2/6zZZT8MdO6632W/elCiv2oglFpZ8y/j5BSeGQrYZlHfb"
                + "2wz38Whko0fgKPA9ff7uS4u+8oMU5XgxhxJddWrh3dO24GVo9lX87NGDjDgQbXQ1E4CeArKmFYHJlngn/cKt1CcpiR67O/9"
                + "V/ja1wKJylUyYCvmd8k29efspse2/BHZ+zk/qlHPsAjxhTfLIkqmup0+tc0DwLuv1uMbBgJPQ15GCGPAw1ky9qay/ynXjj8"
                + "iZNcDyMfKvm6BNJAgMBAAECggEAc7aX8af9h6aGt8ySL7VXh2DhoRtK9VjZdsUBFuRDIjkL8WaqYd2Cksuq9kpVOX1GMxVs"
                + "H8AtDbD+uULVMPufd6P/NrUr0uOPZb6sNPUoDQ4v5GuBEH6ZK3HxS4mIFd/xPwDLmmGM0vKgau1uHNoSibIVn5VnUnqS841"
                + "gSIGIxv/1HI3q2/lPM7nCiTRP8iRlfousQOmmZVm+6h1DKSBaiCe+HZBwLA5IpLzz9XQ4f2N9quaMqp5I6q8pdbIWpL/KXX"
                + "rD1Y7qnZyCgEWaiqLOeoxeNtqRF/BFllXTbvGITm7QrGh5lQoeX2cmYXQQ7j+ohJ2Q+j0H2ffB0VnYgaw0BQKBgQD5badIq"
                + "7Asy367qjhv3q/ygoD+7EhQdNnQ9adN0sm0ecy0CUYqqxAxlCUddC8wEF445dw37wbOcvZoP7ogzMRivHhcTTISHmX12YAv"
                + "umFImUYahcx5ae/Mu6z0r/o+/a1XLwikKxfhEojpMRLJm/OkgmGJx1IkhPM+mxim+X6kXwKBgQDq6S35izCRIs4jJWbs7ct"
                + "6ghMXRlKnomodffwtVAlV1ZwdL3QJoMgmaE3A0Ko7E0GeoX3SoIiA79veSRlHeEwOINsJARGO3Hp0mzaZEN8f4PJyaoOrx9"
                + "PCO2aP9TFFELFapIbmH800nBL2Mxii65FiOTao9wsoD1e6oR+UX1UpVwKBgQDwP5tSlvShoPyYHDQyJOeKigNgCAz7WiH3c"
                + "LZOcosQSAVRIGGydYSqjIxXW3KcNBfdbCH6ykPfFMKc1U0djL5YcDrqhPyGkTsaW/5pend76w6oO1ohVFXC+L52DQ7YH5YY"
                + "FNiY8F0W0LiJDFiRUqKSQXdbs14+iMSW9+L96fD+twKBgEItxPz7YIhS1N4D6HYxG9T8liJFdn2xfNGoL4YZmbOrxRpXxwn"
                + "7WMexNM5wOrT/3Mmy1z6iaTJh4IBD+bIvysVkLjDgMzEbHgiBvaTrouBZQBRJu6SGXDro/yDpQ6Mga8aMeVCVfvsmSRVBGd"
                + "y0HrYcRjDdwC/d+qoiQEJNhTFrAoGBAJqc15i8tlEVjU45uWmJs+mpG6x365MGsC7q9yZ31xUCCx1lwZSlidmaY19q+wGJK"
                + "iYSz/4+KyWuOdRaFbWY/Y4jq7lVinc1S1OR8yqOSyCiYIJaDYHbPsMdZ9twX0aY/QkN+O9RyGnwL4Lmbkt/lry+OyC1vZEF"
                + "SNzdR5kSfNvY";
        String expectString = "ab2d24a78bd8c1b24c20bb86c02b073ff26ef44b728cf0dcec928627dddd29ac";
        byte[] signed = Signer.HmacSM3Sign(stringToSign, sk);
        Assert.assertEquals(expectString, Encoder.hexEncode(signed));
    }

    @Test
    public void SHA256withRSASignTest() throws Exception {
        String stringToSign = "abcdefg";
        String sk = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDk4WyBF8Cj9JVK7ua6nuVfXt2AWdfvhpfSTznM+Dg8m"
                + "4jQwe6OzJV+UkTrY12ugWJuCXdrzyzV4jHScQaazDaS6AQZt2/6zZZT8MdO6632W/elCiv2oglFpZ8y/j5BSeGQrYZlHfb"
                + "2wz38Whko0fgKPA9ff7uS4u+8oMU5XgxhxJddWrh3dO24GVo9lX87NGDjDgQbXQ1E4CeArKmFYHJlngn/cKt1CcpiR67O/9"
                + "V/ja1wKJylUyYCvmd8k29efspse2/BHZ+zk/qlHPsAjxhTfLIkqmup0+tc0DwLuv1uMbBgJPQ15GCGPAw1ky9qay/ynXjj8"
                + "iZNcDyMfKvm6BNJAgMBAAECggEAc7aX8af9h6aGt8ySL7VXh2DhoRtK9VjZdsUBFuRDIjkL8WaqYd2Cksuq9kpVOX1GMxVs"
                + "H8AtDbD+uULVMPufd6P/NrUr0uOPZb6sNPUoDQ4v5GuBEH6ZK3HxS4mIFd/xPwDLmmGM0vKgau1uHNoSibIVn5VnUnqS841"
                + "gSIGIxv/1HI3q2/lPM7nCiTRP8iRlfousQOmmZVm+6h1DKSBaiCe+HZBwLA5IpLzz9XQ4f2N9quaMqp5I6q8pdbIWpL/KXX"
                + "rD1Y7qnZyCgEWaiqLOeoxeNtqRF/BFllXTbvGITm7QrGh5lQoeX2cmYXQQ7j+ohJ2Q+j0H2ffB0VnYgaw0BQKBgQD5badIq"
                + "7Asy367qjhv3q/ygoD+7EhQdNnQ9adN0sm0ecy0CUYqqxAxlCUddC8wEF445dw37wbOcvZoP7ogzMRivHhcTTISHmX12YAv"
                + "umFImUYahcx5ae/Mu6z0r/o+/a1XLwikKxfhEojpMRLJm/OkgmGJx1IkhPM+mxim+X6kXwKBgQDq6S35izCRIs4jJWbs7ct"
                + "6ghMXRlKnomodffwtVAlV1ZwdL3QJoMgmaE3A0Ko7E0GeoX3SoIiA79veSRlHeEwOINsJARGO3Hp0mzaZEN8f4PJyaoOrx9"
                + "PCO2aP9TFFELFapIbmH800nBL2Mxii65FiOTao9wsoD1e6oR+UX1UpVwKBgQDwP5tSlvShoPyYHDQyJOeKigNgCAz7WiH3c"
                + "LZOcosQSAVRIGGydYSqjIxXW3KcNBfdbCH6ykPfFMKc1U0djL5YcDrqhPyGkTsaW/5pend76w6oO1ohVFXC+L52DQ7YH5YY"
                + "FNiY8F0W0LiJDFiRUqKSQXdbs14+iMSW9+L96fD+twKBgEItxPz7YIhS1N4D6HYxG9T8liJFdn2xfNGoL4YZmbOrxRpXxwn"
                + "7WMexNM5wOrT/3Mmy1z6iaTJh4IBD+bIvysVkLjDgMzEbHgiBvaTrouBZQBRJu6SGXDro/yDpQ6Mga8aMeVCVfvsmSRVBGd"
                + "y0HrYcRjDdwC/d+qoiQEJNhTFrAoGBAJqc15i8tlEVjU45uWmJs+mpG6x365MGsC7q9yZ31xUCCx1lwZSlidmaY19q+wGJK"
                + "iYSz/4+KyWuOdRaFbWY/Y4jq7lVinc1S1OR8yqOSyCiYIJaDYHbPsMdZ9twX0aY/QkN+O9RyGnwL4Lmbkt/lry+OyC1vZEF"
                + "SNzdR5kSfNvY";
        String expectString = "8f573b2d43252e5c1d4012da865f649bbf43da8fac508bd6b182ccd9fef6493d21b9cdcdcaad69c7113"
                + "7cd02261834149c3921200fd5b7a8e1ab93471354ee6b9e58378726acc1bcf0d9685d7955f0bb8835884b28e5014851"
                + "49ceeedfbb10e0f4d6731758798fb8cd30382110977357ce61cbd2fff2f04743e1a79634b6741030e23cd3cb0ea2494"
                + "1345b8e3e6adccecd2b12b5b5d3e806fd9ccdab55678ceafbf8f420e8aa7d55be05b4229548966c03218d8945aac80e"
                + "0c8b9f800d0b38a3a2b25d7b430d3ce7415cd184f87f602f9d55a1689756b71eaa3164f82bde25edf4737d0fa3da430"
                + "81d0358ee281b81512681f2820ecc681e10bc7b653f732f3e";
        byte[] signed = Signer.SHA256withRSASign(stringToSign, sk);
        Assert.assertEquals(expectString, Encoder.hexEncode(signed));
    }
}
