package com.svs.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ServiceInjector {
	  private static Injector injector;
	    static {
	        // the default modules.
	        loadModules(new ServiceModule());
	    }

	    public static Injector getInjector() {
	        return injector;
	    }

	    public static <T> T getInstance(Class<T> clazz) {
	        return injector.getInstance(clazz);
	    }

	    public static void loadModules(Module... modules) {
	        injector = Guice.createInjector(modules);
	    }

}
