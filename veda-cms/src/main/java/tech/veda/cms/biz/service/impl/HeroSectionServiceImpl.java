package tech.veda.cms.biz.service.impl;

import tech.veda.cms.biz.mapper.HeroSectionMapper;
import tech.veda.cms.biz.entity.HeroSection;
import tech.veda.cms.biz.service.IHeroSectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
@Service
public class HeroSectionServiceImpl extends ServiceImpl<HeroSectionMapper, HeroSection> implements IHeroSectionService {

  @Override
  public List<HeroSection> findHeroSections() {

    return this.list();
  }

  @Override
  public Boolean updateHeroSections(List<HeroSection> heroSections) {
//    List<Integer> ids = new ArrayList<>();
//    heroSections.stream().forEach(item -> {
//      if(!Objects.isNull(item.getId()) && !item.getId().equals("")){
//        ids.add(item.getId()) ;
//      }else{
//        item.setCreateDate(LocalDateTime.now());
//      }
//    });
//    List<HeroSection> oldHeroSections = this.list();
//    List<Integer> needRemoveHeroSections = new ArrayList<>();
//
//
//    //find the old hero section list in database which are not in request data, and remove them
//    oldHeroSections.stream().forEach(item -> {
//      if(!ids.contains(item.getId())){
//        needRemoveHeroSections.add(item.getId());
//      }
//    });
//    this.removeBatchByIds(needRemoveHeroSections);
    heroSections.stream().forEach(item -> {

      this.saveOrUpdate(item);
    });
    return true;
  }
}

