����   2 A  @com/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage$2  java/lang/Object  (org/eclipse/swt/events/SelectionListener this$0 @Lcom/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage; <init> C(Lcom/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage;)V Code	    
   	  ()V widgetDefaultSelected 5com/genuitec/eclipse/core/activation/ProductActivator %com/genuitec/eclipse/core/LicenseUtil >com/genuitec/eclipse/core/ui/wizard/ManualActivationWizardPage widgetSelected *(Lorg/eclipse/swt/events/SelectionEvent;)V
    4com/genuitec/eclipse/core/ui/wizard/ActivationWizard   
getDefault 9()Lcom/genuitec/eclipse/core/activation/ProductActivator;
       ! " getCurrentLicenseCode ()Ljava/lang/String;
  $ % " getSystemId
  ' ( ) doManualActivation H(Ljava/lang/String;Ljava/lang/String;)Lorg/eclipse/core/runtime/IStatus;
 + -    . / 	getWizard $()Lorg/eclipse/jface/wizard/IWizard;   
 0 3 4  manualActivationCompleted      
  9         > ? createControl &(Lorg/eclipse/swt/widgets/Composite;)V InnerClasses               	 
          
*+� *� �            '     � � � #� &W*� � *� 0� 2�                 *+� 8�      @   
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    