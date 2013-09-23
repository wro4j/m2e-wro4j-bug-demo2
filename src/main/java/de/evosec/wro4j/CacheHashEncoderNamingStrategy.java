package de.evosec.wro4j;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import ro.isdc.wro.model.resource.support.naming.DefaultHashEncoderNamingStrategy;

public class CacheHashEncoderNamingStrategy extends DefaultHashEncoderNamingStrategy {
    public static final String ALIAS = "cacheHashEncoder";

    @Override
    public String rename(final String originalName, final InputStream inputStream) throws IOException {
        Validate.notNull(originalName);
        Validate.notNull(inputStream);
        final String baseName = FilenameUtils.getBaseName(originalName);
        final String path = FilenameUtils.getPath(originalName);
        final String extension = FilenameUtils.getExtension(originalName);
        final String hash = getHashStrategy().getHash(inputStream);
        final StringBuilder sb = new StringBuilder(path).append(baseName).append("-").append(hash).append(".cache");
        if (!StringUtils.isEmpty(extension)) {
            sb.append(".").append(extension);
        }
        return sb.toString();
    }
}
