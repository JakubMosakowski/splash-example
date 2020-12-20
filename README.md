# Snackbar example

### About

Simple project to illustrate approaches to use snackbar with shared view models.
`Master` branch shows the problem, `shared-view-model`, gives one of the possible solutions.

### master
Branch shows how logic could be leaked outside of the fragment while using snackbar with actions.
1. Click on `Navigate to edit screen`.
2. Click any item.
3. Wait for dismissal or click undo.

Everything works as expected.

1. Click on `Navigate to edit screen`.
2. Click any item.
3. Go back.

Now, neither dismissal nor undo action works (view model of the previous fragment was already cleared.)

### shared-view-model
Here everything works as expected.
