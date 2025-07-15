# Playwright Automation Testing with Java 
* Playwright is an open-source automation framework designed for end-to-end testing of modern web applications. Developed by Microsoft. 
* Playwright is a Node.js library that, with a single API, automates websites and web apps running on Chromium, Firefox, and WebKit.
* Playwright enables cross-browser, cross-platform, and cross-language testing with a unified API. It supports both headless and headed browser modes, allowing tests to run locally or in CI (prod) environments.
* Its architecture ensures fast execution and test isolation by creating a new browser context for each test, simulating a fresh browser profile.
* Playwright is distributed as a set of Maven modules. The easiest way to use it is to add one dependency to your project's pom.xml
```
<dependency>
    <groupId>com.microsoft.playwright</groupId>
    <artifactId>playwright</artifactId>
    <version>1.53.0</version>
</dependency>
```
## Key Features 
* Cross-Browser and Cross-Platform – works on Windows, Mac, Linux, all browsers.
* Resilient Testing - Features like auto-wait and web-first assertions reduce flaky tests by waiting for elements to be actionable before performing actions. Resilient Testing refers to writing tests that don’t easily fail just because of timing issues or small delays on the web page.
* Debugging Tool – Playwright Inspector, Codegen, Trace Viewer.
* Automatic Browser Installation & Driver Management - Playwright handles browser binaries and driver installation seamlessly without extra configuration.
* Fast Execution & Test Isolation - Uses a persistent WebSocket connection for efficient communication with browsers and isolates tests by creating fresh browser contexts.

## Architecture
Unlike Selenium, which sends each command as an independent HTTP request to browser drivers, Playwright maintains a single persistent WebSocket connection with all browser instances. This approach reduces latency, improves reliability, and lowers failure points.
Each test runs in an isolated browser context, simulating a fresh user profile, which helps in avoiding side effects between tests and improves test stability.

### Profiling Tools After Test Execution
Once your Playwright test runs, several profiling tabs are available to analyze execution and optimize performance: <br>
<b>Tabs -</b> Flame Graph, Call Tree, Method List, Timeline, Events
* Flame Graph -> Shows which methods were called and how much time they took. The taller the flame, the more time that method consumed.
* Call Tree -> A hierarchical tree of all method calls, starting from main(). Displays how each method led to the next (who called whom).
* Method List -> A flat list of all methods called during your program run. Shows time taken and how often each method was called.
* Timeline -> A visual timeline of your application’s execution. Displays thread activity, method execution, and timings over the run duration.
* Events -> Logs key runtime events. Includes GC activity, thread switches, and any notable changes in state.