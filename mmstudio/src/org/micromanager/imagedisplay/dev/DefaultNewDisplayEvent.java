package org.micromanager.imagedisplay.dev;

import org.micromanager.api.display.DisplayWindow;
import org.micromanager.api.events.NewDisplayEvent;

public class DefaultNewDisplayEvent implements NewDisplayEvent {
   private DisplayWindow window_;

   public DefaultNewDisplayEvent(DisplayWindow window) {
      window_ = window;
   }

   public DisplayWindow getDisplayWindow() {
      return window_;
   }
}