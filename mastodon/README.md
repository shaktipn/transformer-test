# Mastodon Client

The goal of this problem is to create a frontend application that connects to the Mastodon API, incrementally adding features. Mastodon is an alternative to micro-blogging services like X (formerly Twitter)/Threads.

You can build your front end for any one of these platforms:

- Web
- Mobile App
  - Native iOS
  - Native Android
  - Flutter
  - Any other cross-platform framework of your choice

You are free to use any frameworks/libraries of your choice for your platform of choice.

We have provided Figma links that show you a wireframe of what your UI should look like, both for mobile and tablet/desktop. Start with UI for either mobile or tablet/desktop. You will receive extra credit for having support for both mobile and tablet/desktop layouts if you choose to implement both. You are welcome to use any look and feel you feel is best, but your implementation cannot deviate dramatically from the provided wireframes.

You will need to use the Mastodon API for this problem, so it helps to use [the documentation](https://docs.joinmastodon.org/client/intro/) as a reference.

Design Links:

- [Desktop Designs](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=3-2071&t=RtOzH7yk4J4ByBY6-4)
- TODO: ADD MOBILE DESIGNS LINK

## Prerequisites

- You will need a Mastodon account. If you don’t already have one, you can sign up on any Mastodon server. A popular one is [mastodon.social](https://mastodon.social/auth/sign_up).
- You will need a Figma account to view wireframes. If you don’t already have one, you can sign up for one [here](https://www.figma.com).

## Step 1: Build Login Page

Build a Login Page that allows the user to sign in to a mastodon server.

[Figma Design](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=3-2071&t=35hcrkq3jWlsWAeY-4)

- Username and password fields should have basic validations like: fields should not be empty when form is submitted.
- The user should be able to enter username and password, and upon submission, be able to use the app in the following steps.  

### Step 2: Show Public Timeline

Using the [public timeline API](https://docs.joinmastodon.org/methods/timelines/#public) show the latest 20 statuses in reverse chronological order (i.e., newest on top).

[Figma Design](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=1-161415&t=35hcrkq3jWlsWAeY-4)

### Step 3: Enable Scrolling of Public Timeline

As an extension to Step 2, if the user scrolls down on the public timeline, fetch the next 20 statuses. Keep doing this, in an “infinite” scroll manner, as the user continues scrolling.

[Figma Design](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=26-10211&t=RtOzH7yk4J4ByBY6-4)

### Step 4: Enable Status Actions

On each status shown in Steps 2 and 3, add support for the signed in user to take the following actions:

- Bookmark the status
- Favorite the status
- Follow the author of the status

[Figma Design](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=1-161501&t=35hcrkq3jWlsWAeY-4)

### Step 5: Build a Profile Page

Build a profile page for the currently logged-in user as outlined in the wireframe:

[Figma Design](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=1-170786&t=35hcrkq3jWlsWAeY-4)

### Step 6: Enable Profile Pages for All Users

Make the author of each status shown in the public timeline tappable/clickable. When a user taps on the author, it should show the profile page for that user.

[Figma Design](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=26-10553&t=RtOzH7yk4J4ByBY6-4)

### Step 7: Build a Hashtag Search Page

Build a hashtag search page as outlined in the wireframe:

[Figma](https://www.figma.com/design/GA5PmY5BntP8KKcJ6WjY1d/Recruitment-Designs?node-id=1-170482&t=35hcrkq3jWlsWAeY-4)

- The user should be given a list of the currently trending Hashtags when the user clicks on the `Hashtags` tab.
- The user should be able to type and lookup hashtags.
- Upon selecting a hastag the user should see statuses that have mentioned this hashtag.
