<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.0"?> <!-- i18n: added to work around 2.1 bug -->
<plugin>

    
<!-- New Wizards / ME root and addOn categories -->
   <extension
         point="org.eclipse.ui.newWizards">
      <category
            name="%category.newWizards.myeclipse.name"
            id="com.genuitec.eclipse.myeclipse"/>
   </extension>   
      
<!-- Preference Pages -->
   
   <extension
         id="com.genuitec.eclipse.main.preferencepageextension"
         point="org.eclipse.ui.preferencePages">
 
 <!--
     <page
            name="%page.myeclipse.name"
            class="com.genuitec.eclipse.core.ui.preference.MyEclipsePreferencePage"
            id="com.genuitec.eclipse.viper.preferencepage">
      </page>
 -->
 
      <page
            name="%page.viper.preferencepage.licensedetails.name"
            category="com.genuitec.eclipse.viper.preferencepage"
            class="com.genuitec.eclipse.core.ui.preference.LicenseDetailsPreferencePage"
            id="com.genuitec.eclipse.viper.preferencepage.licensedetails">
      </page>
 </extension>
 
    
<!-- ActionSets -->
   <extension
         point="org.eclipse.ui.actionSets">
      <actionSet
            label="%actionSet.myeclipse.actions.label"
            visible="true"
            id="com.genuitec.myeclipse.actions">
<!-- PR-6243: New MyEclipse menu structure -->
         <menu
               label="%menu.myeclipse.label"
               id="com.genuitec.myeclipse.menu">
            <separator
                  name="capabilitiesSeparator">
            </separator>
            <separator
                  name="configurationSeparator">
            </separator>
            <separator
                  name="utilitiesSeparator">
            </separator>
            <separator
                  name="supportSeparator">
            </separator>
         </menu>
              
         <menu
               id="capabilities"
               label="%menu.myeclipse.submenu.capabilities.label"
               path="com.genuitec.myeclipse.menu/capabilitiesSeparator">
            <separator name="additions"/>
         </menu>
         <me