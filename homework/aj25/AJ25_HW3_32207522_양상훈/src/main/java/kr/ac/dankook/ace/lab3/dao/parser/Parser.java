package kr.ac.dankook.ace.lab3.dao.parser;

/*
 * RawParser : 기존 csv 파일을 파싱
 * CleanParser : 새로 만들어진 csv 파일을 파싱
 */
public interface Parser<T> {
    T parse(String line);

}