package tech.vedaSource.cms.sys.service.dto;

import java.util.List;

/**
 * @author Bruno
 */
public record PageDTO<T>(List<T> list, long total) {

}
