package com.globaldex.newlistapp.data.mapper;

import com.globaldex.newlistapp.data.entity.MediaEntity;
import com.globaldex.newlistapp.data.entity.Media_MetadataEntity;
import com.globaldex.newlistapp.data.entity.ResultsEntity;

import java.util.ArrayList;
import java.util.List;

import globaldex.com.newlistapp.domain.model.Media;
import globaldex.com.newlistapp.domain.model.Media_Metadata;
import globaldex.com.newlistapp.domain.model.Results;

/**
 * Created by renjumenon on 20/02/19.
 */
public class NewsListDataMapper {

    public List<Results> transform(List<ResultsEntity> resultsEntities) {
        final List<Results> resultsList = new ArrayList<>();
        for (ResultsEntity resultsEntity : resultsEntities) {
            final Results results = transform(resultsEntity);
            if (results != null) {
                resultsList.add(results);
            }
        }
        return resultsList;
    }


    private Results transform(ResultsEntity resultsEntities) {
        Results resultsList = new Results();
        if (resultsEntities != null) {
            resultsList.setUrl(resultsEntities.getUrl());
            resultsList.setAdxKeywords(resultsEntities.getAdxKeywords());
            if (resultsEntities.getColumn() != null && !resultsEntities.getColumn().isEmpty()) {
                resultsList.setColumn(resultsEntities.getColumn());
            }
            resultsList.setSection(resultsEntities.getSection());
            resultsList.setByline(resultsEntities.getByline());
            resultsList.setType(resultsEntities.getType());
            resultsList.setTitle(resultsEntities.getTitle());
            resultsList.setAbstract(resultsEntities.getAbstract());
            resultsList.setPublishedDate(resultsEntities.getPublishedDate());
            resultsList.setSource(resultsEntities.getSource());
            resultsList.setId(resultsEntities.getId());
            resultsList.setAssetId(resultsEntities.getAssetId());
            resultsList.setViews(resultsEntities.getViews());
            resultsList.setMedia(getMedia(resultsEntities.getMedia()));
            if (resultsEntities.getPerFacet() != null && !resultsEntities.getPerFacet().isEmpty()) {
                resultsList.setPerFacet(resultsEntities.getPerFacet());
            }
            if (resultsEntities.getOrgFacet() != null && !resultsEntities.getOrgFacet().isEmpty()) {
                resultsList.setOrgFacet(resultsEntities.getOrgFacet());
            }
            if (resultsEntities.getDesFacet() != null && !resultsEntities.getDesFacet().isEmpty()) {
                resultsList.setDesFacet(resultsEntities.getDesFacet());
            }
            if (resultsEntities.getOrgFacet() != null && !resultsEntities.getGeoFacet().isEmpty()) {
                resultsList.setGeoFacet(resultsEntities.getGeoFacet());
            }


        }

        return resultsList;

    }

    private List<Media> getMedia(List<MediaEntity> mediaEntities) {
        List<Media> mediaList = new ArrayList<>();
        for (MediaEntity mediaEntity : mediaEntities) {
            if (mediaEntity != null) {
                Media media = new Media();
                media.setApproved_for_syndication(mediaEntity.getApproved_for_syndication());
                media.setCaption(mediaEntity.getCaption());
                media.setCopyright(mediaEntity.getCopyright());
                media.setType(mediaEntity.getType());
                media.setSubtype(mediaEntity.getSubtype());
                media.setMedia_metadata(getMetadata(mediaEntity.getMedia_metadata()));
                mediaList.add(media);
            }
        }
        return mediaList;
    }

    private List<Media_Metadata> getMetadata(List<Media_MetadataEntity> media_metadataEntities) {
        List<Media_Metadata> media_metadataList = new ArrayList<>();
        for (Media_MetadataEntity media_metadataEntity : media_metadataEntities) {
            if (media_metadataEntity != null) {
                Media_Metadata media_metadata = new Media_Metadata();
                media_metadata.setFormat(media_metadataEntity.getFormat());
                media_metadata.setHeight(media_metadataEntity.getHeight());
                media_metadata.setWidth(media_metadataEntity.getWidth());
                media_metadata.setUrl(media_metadataEntity.getUrl());
                media_metadataList.add(media_metadata);
            }
        }
        return media_metadataList;
    }
}
