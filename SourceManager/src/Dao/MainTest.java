����   2 q  @com/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage$1  java/lang/Object  (org/eclipse/swt/events/SelectionListener this$0 @Lcom/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage; <init> C(Lcom/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage;)V Code	    
   	  ()V widgetDefaultSelected java/lang/StringBuilder -com/genuitec/eclipse/core/gsdc/GSDCController %com/genuitec/eclipse/core/LicenseUtil widgetSelected *(Lorg/eclipse/swt/events/SelectionEvent;)V  org/eclipse/swt/dnd/Clipboard  SDC Manual Activation URL: 
   	  (Ljava/lang/String;)V
  !  >com/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage " # getInstance 1()Lcom/genuitec/eclipse/core/gsdc/GSDCController;
  % & ' getActivationServerManualURL ()Ljava/lang/String;
  ) * + append -(Ljava/lang/String;)Ljava/lang/StringBuilder; - 
 / Subscription Code: 
 1 3  org/eclipse/swt/widgets/Shell 4 ' getCurrentLicenseCode 6 System ID: 
 1 8 9 ' getSystemId
  ; < ' toString  org/eclipse/swt/dnd/Transfer
 @ B    org/eclipse/swt/dnd/TextTransfe