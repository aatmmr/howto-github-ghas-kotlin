# How To: GitHub Advanced Security with Kotlin

This project aims to provide a comprehensive guide on how to integrate GitHub Advanced Security (GHAS) with a Kotlin project. It covers the setup process, configuration options, and best practices for leveraging GHAS to enhance the security of your Kotlin applications. Whether you are a beginner or an experienced developer, this guide will help you get started with GHAS and ensure the security of your Kotlin projects.

## Known Vulnerabilities

The file `app/src/main/kotlin/org/example/App.`kt` contains known vulnerabilities that can be detected by GHAS. The vulnerabilities are:

- Logging of sensitive information

## Code Scanning

Code Scanning is automatically started when a PR is created or on user demand through `workflow_dispatch`. The check is configured in "Advanced Mode", i.e. via a workflow file in the repository. The workflow file is located at `.github/workflows/codeql.yml`.

In order to cover as much as possible, not only query packs but also a java community pack from [CodeQL-Community-Packs](https://github.com/GitHubSecurityLab/CodeQL-Community-Packs) is added to the scan via `packs` in the CodeQL initialization step:

```yaml
- name: Initialize CodeQL
      uses: github/codeql-action/init@v3
      with:
        languages: java-kotlin
        build-mode: autobuild
        queries: security-extended,security-and-quality
        packs: githubsecuritylab/codeql-java-queries
```