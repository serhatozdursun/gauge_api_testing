package helper;

import enums.GsmType;
import enums.MailType;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomHelper {

    /**
     * Rastgele hotmail adresi üretir
     *
     * @return String
     */
    public String generateMail() {
        return generateMail(generateNumberBetweenTwoBound(4, 10));
    }

    /**
     * Rastgele hotmail adresi üretir
     *
     * @param numberOfDigit adres uzunluğu kaç karakter olsun?
     * @return String
     */
    public String generateMail(int numberOfDigit) {
        return generateMail(numberOfDigit, MailType.HOTMAIL);
    }

    /**
     * Rastgele mail adresi üretir
     *
     * @param numberOfDigit adres uzunluğu kaç karakter olsun?
     * @param mailType      mail tipi ne olsun? Örn: hotmail, yahoo, gmail
     * @return String
     */
    public String generateMail(int numberOfDigit, MailType mailType) {
        return generateAlphabetic(numberOfDigit).toLowerCase() + mailType.extension;
    }

    /**
     * Rastgele telefon numarası üretir
     *
     * @return String
     */
    public String generateGsmNumber() {
        return generateGsmNumber(GsmType.TURKCELL);
    }

    /**
     * Rastgele telefon numarası üretir
     *
     * @param gsmType Gsm operatörü ne olsun? Örn: Vodafone, Turkcell vb.
     * @return String
     */
    public String generateGsmNumber(GsmType gsmType) {
        int areCodeListSize = gsmType.areCodeList.size();
        String areaCode = gsmType.areCodeList.get(generateNumber(areCodeListSize));
        String bodyCode = generateNumberByNumberOfDigit(7);
        return areaCode + bodyCode;
    }

    /**
     * Belirtilen basamak sayısı uzunluğunda rastgele sayı üretir.
     * Örn: 10 basamaklı rastgele sayı üretmek için parametreye 10 değeri geçin.
     *
     * @param numberOfDigit basamak sayısı:
     * @return String
     */
    public String generateNumberByNumberOfDigit(int numberOfDigit) {
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < numberOfDigit; i++) {
            int generatedNumber = generateNumber(10);

            if (i == 0 && generatedNumber == 0)
                ++generatedNumber;
            randomNumber.append(generatedNumber);
        }
        return randomNumber.toString();
    }

    /**
     * 0 ile sınır değeri arasında rastgele sayı veya rakam üretir.
     *
     * @param bound sınır değeri
     * @return int
     */
    public int generateNumber(int bound) {
        return new Random().nextInt(bound);
    }


    /**
     * A-Z, a-z, 0-9 değeri arasında rastgele üretim yapar.
     *
     * @param numberOfDigit basamak sayısı
     * @return String
     */
    public String generateAlphanumeric(int numberOfDigit) {
        return RandomStringUtils.randomAlphanumeric(numberOfDigit);
    }

    /**
     * A-Z ve a-z değerleri arasında rastgele üretim yapar.
     *
     * @param numberOfDigit basamak sayısı
     * @return String
     */
    public String generateAlphabetic(int numberOfDigit) {
        return RandomStringUtils.randomAlphabetic(numberOfDigit);
    }

    /**
     * İki sınır değeri arasında sayı üretir.
     * Örn: 5 ile 10 arasında değer üretmek istiyorsanız parametreye 5 ve 10 değeri geçin.
     * Not: üretime sınır değerler dahildir.
     *
     * @param beginBound başlangıç değeri
     * @param endBound   bitir değeri
     * @return int
     */
    public int generateNumberBetweenTwoBound(int beginBound, int endBound) {
        if (beginBound > endBound) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        } else {
            return generateNumber((endBound - beginBound) + 1) + beginBound;
        }
    }

    /**
     * Rastgele TCKN üretir.
     *
     * @return String
     */
    public String generateTckn() {

        return new TCKNHelper().getTckn();
    }
}
