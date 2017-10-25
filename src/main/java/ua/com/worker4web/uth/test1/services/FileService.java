package ua.com.worker4web.uth.test1.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by worker4web on 10/25/2017.
 */
@Service
public class FileService {

    private static String fileName = "ipblacklist.txt";
    private static Path ipFile;
    private static FileTime fileTime;
    private static Set<String> ipList;


    public boolean isBlok(String ip) {
        checkFile();
        if(ipList!=null && ipList.contains(ip))
            return true;
        return false;
    }

    private void checkFile() {
        ipFile = Paths.get(fileName);
        try {
            if(ipFile != null) {
                FileTime curTime = Files.getLastModifiedTime(ipFile, LinkOption.NOFOLLOW_LINKS);
                if (!curTime.equals(fileTime)) {
                    fileTime = curTime;
                    loadBlackList();
                }
            }
        }
        catch (IOException ex) {
            System.out.println("IP file not found!");
        }
    }
    private void loadBlackList() throws IOException {
        ipList = Files.lines(ipFile).collect(Collectors.toCollection(TreeSet::new));
    }


}
