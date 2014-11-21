/*
 * Copyright 2010-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.di;

import com.intellij.openapi.project.Project;
import org.jetbrains.jet.context.GlobalContext;
import org.jetbrains.jet.storage.StorageManager;
import org.jetbrains.jet.lang.resolve.BindingTrace;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptor;
import org.jetbrains.jet.lang.PlatformToKotlinClassMap;
import org.jetbrains.jet.lang.resolve.TopDownAnalyzer;
import org.jetbrains.jet.lang.resolve.LazyTopDownAnalyzer;
import org.jetbrains.jet.lang.resolve.MutablePackageFragmentProvider;
import org.jetbrains.jet.lang.resolve.java.JavaDescriptorResolver;
import org.jetbrains.jet.lang.resolve.kotlin.DeserializationGlobalContextForJava;
import org.jetbrains.jet.lang.resolve.AdditionalCheckerProvider;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.jet.lang.resolve.java.JavaClassFinderImpl;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedExternalSignatureResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedJavaResolverCache;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedErrorReporter;
import org.jetbrains.jet.lang.resolve.java.resolver.PsiBasedMethodSignatureChecker;
import org.jetbrains.jet.lang.resolve.java.resolver.PsiBasedExternalAnnotationResolver;
import org.jetbrains.jet.lang.resolve.java.structure.impl.JavaPropertyInitializerEvaluatorImpl;
import org.jetbrains.jet.lang.resolve.java.sam.SamConversionResolverImpl;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaSourceElementFactoryImpl;
import org.jetbrains.jet.lang.resolve.java.lazy.SingleModuleClassResolver;
import org.jetbrains.jet.lang.resolve.java.JavaFlexibleTypeCapabilitiesProvider;
import org.jetbrains.jet.lang.resolve.kotlin.VirtualFileFinder;
import org.jetbrains.jet.lang.resolve.BodyResolver;
import org.jetbrains.jet.lang.resolve.AnnotationResolver;
import org.jetbrains.jet.lang.resolve.calls.CallResolver;
import org.jetbrains.jet.lang.resolve.calls.ArgumentTypeResolver;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingServices;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingComponents;
import org.jetbrains.jet.lang.types.expressions.ControlStructureTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ForLoopConventionsChecker;
import org.jetbrains.jet.lang.reflect.ReflectionTypes;
import org.jetbrains.jet.lang.resolve.calls.CallExpressionResolver;
import org.jetbrains.jet.lang.resolve.DescriptorResolver;
import org.jetbrains.jet.lang.resolve.DelegatedPropertyResolver;
import org.jetbrains.jet.lang.resolve.TypeResolver;
import org.jetbrains.jet.lang.resolve.QualifiedExpressionResolver;
import org.jetbrains.jet.context.LazinessToken;
import org.jetbrains.jet.lang.resolve.calls.CallResolverExtensionProvider;
import org.jetbrains.jet.lang.resolve.PartialBodyResolveProvider;
import org.jetbrains.jet.lang.resolve.calls.CallCompleter;
import org.jetbrains.jet.lang.resolve.calls.CandidateResolver;
import org.jetbrains.jet.lang.resolve.calls.tasks.TaskPrioritizer;
import org.jetbrains.jet.lang.resolve.ControlFlowAnalyzer;
import org.jetbrains.jet.lang.resolve.DeclarationsChecker;
import org.jetbrains.jet.lang.resolve.ModifiersChecker;
import org.jetbrains.jet.lang.resolve.FunctionAnalyzerExtension;
import org.jetbrains.jet.lang.resolve.ScriptBodyResolver;
import org.jetbrains.jet.lang.resolve.DeclarationResolver;
import org.jetbrains.jet.lang.resolve.ImportsResolver;
import org.jetbrains.jet.lang.psi.JetImportsFactory;
import org.jetbrains.jet.lang.resolve.OverloadResolver;
import org.jetbrains.jet.lang.resolve.OverrideResolver;
import org.jetbrains.jet.lang.resolve.TypeHierarchyResolver;
import org.jetbrains.jet.lang.resolve.ScriptHeaderResolver;
import org.jetbrains.jet.lang.resolve.java.lazy.LazyJavaPackageFragmentProvider;
import org.jetbrains.jet.lang.resolve.java.lazy.GlobalJavaResolverContext;
import org.jetbrains.jet.lang.resolve.kotlin.DeserializedDescriptorResolver;
import org.jetbrains.jet.lang.resolve.kotlin.JavaClassDataFinder;
import org.jetbrains.jet.lang.resolve.kotlin.AnnotationDescriptorLoader;
import org.jetbrains.jet.lang.resolve.kotlin.DescriptorLoadersStorage;
import org.jetbrains.jet.lang.resolve.kotlin.ConstantDescriptorLoader;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.InjectorsPackage. DO NOT EDIT! */
@SuppressWarnings("all")
public class InjectorForTopDownAnalyzerForJvm {

    private final Project project;
    private final GlobalContext globalContext;
    private final StorageManager storageManager;
    private final BindingTrace bindingTrace;
    private final ModuleDescriptor moduleDescriptor;
    private final PlatformToKotlinClassMap platformToKotlinClassMap;
    private final TopDownAnalyzer topDownAnalyzer;
    private final LazyTopDownAnalyzer lazyTopDownAnalyzer;
    private final MutablePackageFragmentProvider mutablePackageFragmentProvider;
    private final JavaDescriptorResolver javaDescriptorResolver;
    private final DeserializationGlobalContextForJava deserializationGlobalContextForJava;
    private final AdditionalCheckerProvider additionalCheckerProvider;
    private final GlobalSearchScope globalSearchScope;
    private final JavaClassFinderImpl javaClassFinder;
    private final TraceBasedExternalSignatureResolver traceBasedExternalSignatureResolver;
    private final TraceBasedJavaResolverCache traceBasedJavaResolverCache;
    private final TraceBasedErrorReporter traceBasedErrorReporter;
    private final PsiBasedMethodSignatureChecker psiBasedMethodSignatureChecker;
    private final PsiBasedExternalAnnotationResolver psiBasedExternalAnnotationResolver;
    private final JavaPropertyInitializerEvaluatorImpl javaPropertyInitializerEvaluator;
    private final SamConversionResolverImpl samConversionResolver;
    private final JavaSourceElementFactoryImpl javaSourceElementFactory;
    private final SingleModuleClassResolver singleModuleClassResolver;
    private final JavaFlexibleTypeCapabilitiesProvider javaFlexibleTypeCapabilitiesProvider;
    private final VirtualFileFinder virtualFileFinder;
    private final BodyResolver bodyResolver;
    private final AnnotationResolver annotationResolver;
    private final CallResolver callResolver;
    private final ArgumentTypeResolver argumentTypeResolver;
    private final ExpressionTypingServices expressionTypingServices;
    private final ExpressionTypingComponents expressionTypingComponents;
    private final ControlStructureTypingUtils controlStructureTypingUtils;
    private final ExpressionTypingUtils expressionTypingUtils;
    private final ForLoopConventionsChecker forLoopConventionsChecker;
    private final ReflectionTypes reflectionTypes;
    private final CallExpressionResolver callExpressionResolver;
    private final DescriptorResolver descriptorResolver;
    private final DelegatedPropertyResolver delegatedPropertyResolver;
    private final TypeResolver typeResolver;
    private final QualifiedExpressionResolver qualifiedExpressionResolver;
    private final LazinessToken lazinessToken;
    private final CallResolverExtensionProvider callResolverExtensionProvider;
    private final PartialBodyResolveProvider partialBodyResolveProvider;
    private final CallCompleter callCompleter;
    private final CandidateResolver candidateResolver;
    private final TaskPrioritizer taskPrioritizer;
    private final ControlFlowAnalyzer controlFlowAnalyzer;
    private final DeclarationsChecker declarationsChecker;
    private final ModifiersChecker modifiersChecker;
    private final FunctionAnalyzerExtension functionAnalyzerExtension;
    private final ScriptBodyResolver scriptBodyResolver;
    private final DeclarationResolver declarationResolver;
    private final ImportsResolver importsResolver;
    private final JetImportsFactory jetImportsFactory;
    private final OverloadResolver overloadResolver;
    private final OverrideResolver overrideResolver;
    private final TypeHierarchyResolver typeHierarchyResolver;
    private final ScriptHeaderResolver scriptHeaderResolver;
    private final LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider;
    private final GlobalJavaResolverContext globalJavaResolverContext;
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final JavaClassDataFinder javaClassDataFinder;
    private final AnnotationDescriptorLoader annotationDescriptorLoader;
    private final DescriptorLoadersStorage descriptorLoadersStorage;
    private final ConstantDescriptorLoader constantDescriptorLoader;

    public InjectorForTopDownAnalyzerForJvm(
        @NotNull Project project,
        @NotNull GlobalContext globalContext,
        @NotNull BindingTrace bindingTrace,
        @NotNull ModuleDescriptor moduleDescriptor
    ) {
        this.project = project;
        this.globalContext = globalContext;
        this.storageManager = globalContext.getStorageManager();
        this.bindingTrace = bindingTrace;
        this.moduleDescriptor = moduleDescriptor;
        this.platformToKotlinClassMap = moduleDescriptor.getPlatformToKotlinClassMap();
        this.topDownAnalyzer = new TopDownAnalyzer();
        this.lazyTopDownAnalyzer = new LazyTopDownAnalyzer();
        this.mutablePackageFragmentProvider = new MutablePackageFragmentProvider(getModuleDescriptor());
        this.javaClassFinder = new JavaClassFinderImpl();
        this.virtualFileFinder = org.jetbrains.jet.lang.resolve.kotlin.VirtualFileFinder.SERVICE.getInstance(project);
        this.deserializedDescriptorResolver = new DeserializedDescriptorResolver();
        this.psiBasedExternalAnnotationResolver = new PsiBasedExternalAnnotationResolver();
        this.traceBasedExternalSignatureResolver = new TraceBasedExternalSignatureResolver();
        this.traceBasedErrorReporter = new TraceBasedErrorReporter();
        this.psiBasedMethodSignatureChecker = new PsiBasedMethodSignatureChecker();
        this.traceBasedJavaResolverCache = new TraceBasedJavaResolverCache();
        this.javaPropertyInitializerEvaluator = new JavaPropertyInitializerEvaluatorImpl();
        this.samConversionResolver = SamConversionResolverImpl.INSTANCE$;
        this.javaSourceElementFactory = new JavaSourceElementFactoryImpl();
        this.singleModuleClassResolver = new SingleModuleClassResolver();
        this.globalJavaResolverContext = new GlobalJavaResolverContext(storageManager, javaClassFinder, virtualFileFinder, deserializedDescriptorResolver, psiBasedExternalAnnotationResolver, traceBasedExternalSignatureResolver, traceBasedErrorReporter, psiBasedMethodSignatureChecker, traceBasedJavaResolverCache, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, singleModuleClassResolver);
        this.lazyJavaPackageFragmentProvider = new LazyJavaPackageFragmentProvider(globalJavaResolverContext, getModuleDescriptor());
        this.javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProvider, getModuleDescriptor());
        this.javaClassDataFinder = new JavaClassDataFinder(virtualFileFinder, deserializedDescriptorResolver);
        this.annotationDescriptorLoader = new AnnotationDescriptorLoader();
        this.constantDescriptorLoader = new ConstantDescriptorLoader();
        this.deserializationGlobalContextForJava = new DeserializationGlobalContextForJava(storageManager, getModuleDescriptor(), javaClassDataFinder, annotationDescriptorLoader, constantDescriptorLoader, lazyJavaPackageFragmentProvider);
        this.additionalCheckerProvider = org.jetbrains.jet.lang.resolve.kotlin.JavaDeclarationCheckerProvider.INSTANCE$;
        this.globalSearchScope = com.intellij.psi.search.GlobalSearchScope.allScope(project);
        this.javaFlexibleTypeCapabilitiesProvider = new JavaFlexibleTypeCapabilitiesProvider();
        this.bodyResolver = new BodyResolver();
        this.annotationResolver = new AnnotationResolver();
        this.callResolver = new CallResolver();
        this.argumentTypeResolver = new ArgumentTypeResolver();
        this.expressionTypingComponents = new ExpressionTypingComponents();
        this.expressionTypingServices = new ExpressionTypingServices(expressionTypingComponents);
        this.controlStructureTypingUtils = new ControlStructureTypingUtils(expressionTypingServices);
        this.expressionTypingUtils = new ExpressionTypingUtils(expressionTypingServices, callResolver);
        this.forLoopConventionsChecker = new ForLoopConventionsChecker();
        this.reflectionTypes = new ReflectionTypes(getModuleDescriptor());
        this.callExpressionResolver = new CallExpressionResolver();
        this.descriptorResolver = new DescriptorResolver();
        this.delegatedPropertyResolver = new DelegatedPropertyResolver();
        this.qualifiedExpressionResolver = new QualifiedExpressionResolver();
        this.lazinessToken = new LazinessToken();
        this.typeResolver = new TypeResolver(annotationResolver, qualifiedExpressionResolver, getModuleDescriptor(), javaFlexibleTypeCapabilitiesProvider, storageManager, lazinessToken);
        this.callResolverExtensionProvider = new CallResolverExtensionProvider();
        this.partialBodyResolveProvider = new PartialBodyResolveProvider();
        this.candidateResolver = new CandidateResolver();
        this.callCompleter = new CallCompleter(argumentTypeResolver, candidateResolver);
        this.taskPrioritizer = new TaskPrioritizer(storageManager);
        this.controlFlowAnalyzer = new ControlFlowAnalyzer();
        this.declarationsChecker = new DeclarationsChecker();
        this.modifiersChecker = new ModifiersChecker(bindingTrace, additionalCheckerProvider);
        this.functionAnalyzerExtension = new FunctionAnalyzerExtension();
        this.scriptBodyResolver = new ScriptBodyResolver();
        this.declarationResolver = new DeclarationResolver();
        this.importsResolver = new ImportsResolver();
        this.jetImportsFactory = new JetImportsFactory();
        this.overloadResolver = new OverloadResolver();
        this.overrideResolver = new OverrideResolver();
        this.typeHierarchyResolver = new TypeHierarchyResolver();
        this.scriptHeaderResolver = new ScriptHeaderResolver();
        this.descriptorLoadersStorage = new DescriptorLoadersStorage(storageManager);

        this.topDownAnalyzer.setAdditionalCheckerProvider(additionalCheckerProvider);
        this.topDownAnalyzer.setBodyResolver(bodyResolver);
        this.topDownAnalyzer.setDeclarationResolver(declarationResolver);
        this.topDownAnalyzer.setLazyTopDownAnalyzer(lazyTopDownAnalyzer);
        this.topDownAnalyzer.setModuleDescriptor(moduleDescriptor);
        this.topDownAnalyzer.setOverloadResolver(overloadResolver);
        this.topDownAnalyzer.setOverrideResolver(overrideResolver);
        this.topDownAnalyzer.setPackageFragmentProvider(mutablePackageFragmentProvider);
        this.topDownAnalyzer.setProject(project);
        this.topDownAnalyzer.setTrace(bindingTrace);
        this.topDownAnalyzer.setTypeHierarchyResolver(typeHierarchyResolver);

        this.lazyTopDownAnalyzer.setBodyResolver(bodyResolver);
        this.lazyTopDownAnalyzer.setDeclarationResolver(declarationResolver);
        this.lazyTopDownAnalyzer.setModuleDescriptor(moduleDescriptor);
        this.lazyTopDownAnalyzer.setOverloadResolver(overloadResolver);
        this.lazyTopDownAnalyzer.setOverrideResolver(overrideResolver);
        this.lazyTopDownAnalyzer.setTrace(bindingTrace);

        javaClassFinder.setProject(project);
        javaClassFinder.setScope(globalSearchScope);

        traceBasedExternalSignatureResolver.setExternalAnnotationResolver(psiBasedExternalAnnotationResolver);
        traceBasedExternalSignatureResolver.setProject(project);
        traceBasedExternalSignatureResolver.setTrace(bindingTrace);

        traceBasedJavaResolverCache.setTrace(bindingTrace);

        traceBasedErrorReporter.setTrace(bindingTrace);

        psiBasedMethodSignatureChecker.setExternalAnnotationResolver(psiBasedExternalAnnotationResolver);
        psiBasedMethodSignatureChecker.setExternalSignatureResolver(traceBasedExternalSignatureResolver);

        singleModuleClassResolver.setResolver(javaDescriptorResolver);

        bodyResolver.setAnnotationResolver(annotationResolver);
        bodyResolver.setCallResolver(callResolver);
        bodyResolver.setControlFlowAnalyzer(controlFlowAnalyzer);
        bodyResolver.setDeclarationsChecker(declarationsChecker);
        bodyResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        bodyResolver.setExpressionTypingServices(expressionTypingServices);
        bodyResolver.setFunctionAnalyzerExtension(functionAnalyzerExtension);
        bodyResolver.setScriptBodyResolverResolver(scriptBodyResolver);
        bodyResolver.setTrace(bindingTrace);

        annotationResolver.setCallResolver(callResolver);
        annotationResolver.setStorageManager(storageManager);
        annotationResolver.setTypeResolver(typeResolver);

        callResolver.setArgumentTypeResolver(argumentTypeResolver);
        callResolver.setCallCompleter(callCompleter);
        callResolver.setCandidateResolver(candidateResolver);
        callResolver.setExpressionTypingServices(expressionTypingServices);
        callResolver.setTaskPrioritizer(taskPrioritizer);
        callResolver.setTypeResolver(typeResolver);

        argumentTypeResolver.setExpressionTypingServices(expressionTypingServices);
        argumentTypeResolver.setTypeResolver(typeResolver);

        expressionTypingServices.setAnnotationResolver(annotationResolver);
        expressionTypingServices.setCallExpressionResolver(callExpressionResolver);
        expressionTypingServices.setCallResolver(callResolver);
        expressionTypingServices.setDescriptorResolver(descriptorResolver);
        expressionTypingServices.setExtensionProvider(callResolverExtensionProvider);
        expressionTypingServices.setPartialBodyResolveProvider(partialBodyResolveProvider);
        expressionTypingServices.setProject(project);
        expressionTypingServices.setTypeResolver(typeResolver);

        expressionTypingComponents.setAdditionalCheckerProvider(additionalCheckerProvider);
        expressionTypingComponents.setCallResolver(callResolver);
        expressionTypingComponents.setControlStructureTypingUtils(controlStructureTypingUtils);
        expressionTypingComponents.setExpressionTypingServices(expressionTypingServices);
        expressionTypingComponents.setExpressionTypingUtils(expressionTypingUtils);
        expressionTypingComponents.setForLoopConventionsChecker(forLoopConventionsChecker);
        expressionTypingComponents.setGlobalContext(globalContext);
        expressionTypingComponents.setPlatformToKotlinClassMap(platformToKotlinClassMap);
        expressionTypingComponents.setReflectionTypes(reflectionTypes);

        forLoopConventionsChecker.setExpressionTypingServices(expressionTypingServices);
        forLoopConventionsChecker.setExpressionTypingUtils(expressionTypingUtils);
        forLoopConventionsChecker.setProject(project);

        callExpressionResolver.setExpressionTypingServices(expressionTypingServices);

        descriptorResolver.setAnnotationResolver(annotationResolver);
        descriptorResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        descriptorResolver.setExpressionTypingServices(expressionTypingServices);
        descriptorResolver.setStorageManager(storageManager);
        descriptorResolver.setTypeResolver(typeResolver);

        delegatedPropertyResolver.setCallResolver(callResolver);
        delegatedPropertyResolver.setExpressionTypingServices(expressionTypingServices);

        candidateResolver.setArgumentTypeResolver(argumentTypeResolver);

        controlFlowAnalyzer.setTrace(bindingTrace);

        declarationsChecker.setDescriptorResolver(descriptorResolver);
        declarationsChecker.setModifiersChecker(modifiersChecker);
        declarationsChecker.setTrace(bindingTrace);

        functionAnalyzerExtension.setTrace(bindingTrace);

        scriptBodyResolver.setExpressionTypingServices(expressionTypingServices);

        declarationResolver.setAnnotationResolver(annotationResolver);
        declarationResolver.setDescriptorResolver(descriptorResolver);
        declarationResolver.setImportsResolver(importsResolver);
        declarationResolver.setTrace(bindingTrace);

        importsResolver.setImportsFactory(jetImportsFactory);
        importsResolver.setModuleDescriptor(moduleDescriptor);
        importsResolver.setQualifiedExpressionResolver(qualifiedExpressionResolver);
        importsResolver.setTrace(bindingTrace);

        jetImportsFactory.setProject(project);

        overloadResolver.setTrace(bindingTrace);

        overrideResolver.setTrace(bindingTrace);

        typeHierarchyResolver.setDescriptorResolver(descriptorResolver);
        typeHierarchyResolver.setImportsResolver(importsResolver);
        typeHierarchyResolver.setPackageFragmentProvider(mutablePackageFragmentProvider);
        typeHierarchyResolver.setScriptHeaderResolver(scriptHeaderResolver);
        typeHierarchyResolver.setTrace(bindingTrace);

        scriptHeaderResolver.setPackageFragmentProvider(mutablePackageFragmentProvider);
        scriptHeaderResolver.setTrace(bindingTrace);

        deserializedDescriptorResolver.setContext(deserializationGlobalContextForJava);
        deserializedDescriptorResolver.setErrorReporter(traceBasedErrorReporter);

        annotationDescriptorLoader.setErrorReporter(traceBasedErrorReporter);
        annotationDescriptorLoader.setKotlinClassFinder(virtualFileFinder);
        annotationDescriptorLoader.setModule(moduleDescriptor);
        annotationDescriptorLoader.setStorage(descriptorLoadersStorage);

        descriptorLoadersStorage.setErrorReporter(traceBasedErrorReporter);
        descriptorLoadersStorage.setModule(moduleDescriptor);

        constantDescriptorLoader.setErrorReporter(traceBasedErrorReporter);
        constantDescriptorLoader.setKotlinClassFinder(virtualFileFinder);
        constantDescriptorLoader.setStorage(descriptorLoadersStorage);

        javaClassFinder.initialize();

    }

    @PreDestroy
    public void destroy() {
    }

    public ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public TopDownAnalyzer getTopDownAnalyzer() {
        return this.topDownAnalyzer;
    }

    public LazyTopDownAnalyzer getLazyTopDownAnalyzer() {
        return this.lazyTopDownAnalyzer;
    }

    public JavaDescriptorResolver getJavaDescriptorResolver() {
        return this.javaDescriptorResolver;
    }

    public DeserializationGlobalContextForJava getDeserializationGlobalContextForJava() {
        return this.deserializationGlobalContextForJava;
    }

}
