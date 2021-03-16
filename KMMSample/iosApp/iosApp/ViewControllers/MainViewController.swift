//
//  MainViewController.swift
//  iosApp
//
//  Created by Mohammed Hanifbiji on 22/01/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared

class MainViewController: UIViewController {
    
    // MARK: - Outlets
    @IBOutlet weak var tblViewMovies: UITableView!
    @IBOutlet weak var progressbar: UIActivityIndicatorView!
    
    // MARK: - Variables
    fileprivate var movieList : [MovieEntity] = []
    fileprivate var viewModel: MainViewModel?
    
    // MARK: - UIViewController Life Cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        viewModel = MainViewModel()
        viewModel?.getMovies()
        bindData()
    }
    
    /// Bind ViewModel and observe api callback
    fileprivate func bindData() {
        viewModel?.apiCallback = { [weak self] (movies, error) in
            guard let `self` = self else {
                return
            }
            self.progressbar.isHidden = true
            if error != nil {
                self.showAlert(message: error?.errorResponse?.status_message ?? "")
            } else {
                self.movieList = movies as? [MovieEntity] ?? []
                self.tblViewMovies.reloadData()
                self.tblViewMovies.isHidden = false
            }
        }
    }
    
    /// Show Alert
    /// - Parameter message: Message received from Api.
    fileprivate func showAlert(message: String) {
        let alert = UIAlertController(title: ConstantStrings.alertTitle, message: message, preferredStyle: UIAlertController.Style.alert)
        alert.addAction(UIAlertAction(title: ConstantStrings.ok, style: UIAlertAction.Style.default, handler: nil))
        self.present(alert, animated: true, completion: nil)
    }
    
}

// MARK: - UITableViewDataSource
extension MainViewController: UITableViewDataSource {
    
    /// Use this to set number od rows we want in our tableView
    /// - Parameters:
    ///   - tableView: UITableView
    ///   - section: TableView Section
    /// - Returns: Count of rows present
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return movieList.count
    }
    
    /// Use this to set data in tableView Cell
    /// - Parameters:
    ///   - tableView: UITableView
    ///   - indexPath: indexpath
    /// - Returns: Returns our custom cell or UITableViewCell itself
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // TODO: Api call
        guard let tableViewCell = tableView.dequeueReusableCell(withIdentifier: ConstantStrings.movieCell, for: indexPath) as? MoviesCell else {
            return UITableViewCell()
        }
        let movie = movieList[indexPath.row]
        tableViewCell.setUpMoviesData(movieEntity: movie)
        return tableViewCell
    }
    
}
