package com.pri.pri;

import net.fenghaitao.AutoExcel;
import net.fenghaitao.imports.DataSet;
import net.fenghaitao.parameters.FieldSetting;
import net.fenghaitao.parameters.ImportPara;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <BR>
 * author: ChenQi <BR>
 * createDate: 2021/10/13 <BR>
 */
@SpringBootTest
public class AutoExcelTest {


    @Test
    public void importExcel() {
        List<ImportPara> importParas = new ArrayList<ImportPara>() {{
            add(new ImportPara(0, genProductFieldSettings()));
            // add(new ImportPara(1, genProjectFieldSettings(), 1, 5));
        }};
        String fileName = this.getClass().getResource("/").getPath() + "Export.xlsx";
        // String fileName = this.getClass().getResource("D:/Export.xlsx").getPath();
        DataSet dataSet = AutoExcel.read(fileName, importParas);
        // 方式一、直接获取数据，没有类型转换，可通过这种方式检验数据是否符合要求
        List<Map<String, Object>> products = dataSet.get("Projects");
        List<Map<String, Object>> projects = dataSet.get("Project");
        // 方式二、通过sheet索引获取指定类的数据，类型自动转换，转换失败将抛出异常
        // List<Product> products = dataSet.get(0, Product.class);
        // List<Project> projects= dataSet.get(1, Project.class);
        // 方式三、通过sheet名称获取指定类的数据，类型自动转换，转换失败将抛出异常
        // List<Product> products = dataSet.get("Product", Product.class);
        // List<Project> projects = dataSet.get("Project", Project.class);
    }

    public static List<FieldSetting> genProjectFieldSettings() {
        List<FieldSetting> fieldSettings = new ArrayList<>();
        fieldSettings.add(new FieldSetting("projName", "Project Name"));
        fieldSettings.add(new FieldSetting("projInfo", "Project Info."));
        fieldSettings.add(new FieldSetting("basalArea", "Basal Area"));
        fieldSettings.add(new FieldSetting("availableArea", "Available Area"));
        fieldSettings.add(new FieldSetting("buildingArea", "Building Area"));
        fieldSettings.add(new FieldSetting("buildingsNumber", "Buildings Number"));
        fieldSettings.add(new FieldSetting("saleStartDate", "Sales Start Date"));
        fieldSettings.add(new FieldSetting("landAcquisitionTime", "Land Acquisition Time"));
        fieldSettings.add(new FieldSetting("availablePrice", "Available Price"));
        fieldSettings.add(new FieldSetting("availableAmount", "Available Amount"));
        fieldSettings.add(new FieldSetting("insideArea", "Inside Area"));
        return fieldSettings;
    }

    public static List<FieldSetting> genProductFieldSettings() {
        List<FieldSetting> fieldSettings = new ArrayList<>();
        fieldSettings.add(new FieldSetting("projName", "Project Name"));
        fieldSettings.add(new FieldSetting("basalArea", "Basal Area"));
        fieldSettings.add(new FieldSetting("buildingArea", "Building Area"));
        fieldSettings.add(new FieldSetting("insideArea", "Inside Area"));
        fieldSettings.add(new FieldSetting("availableArea", "Available Area"));
        fieldSettings.add(new FieldSetting("availablePrice", "Available Price"));
        fieldSettings.add(new FieldSetting("availableAmount", "Available Amount"));
        return fieldSettings;
    }
}
