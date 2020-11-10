package service;

import java.io.File;
import java.io.FileNotFoundException;

interface IFileParser {

    File parseFile(String fileName) throws FileNotFoundException;
}
